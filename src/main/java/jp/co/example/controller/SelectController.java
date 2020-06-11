package jp.co.example.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.dao.JoinDao;
import jp.co.example.dao.PartyDao;
import jp.co.example.entity.Join;
import jp.co.example.entity.Party;
import jp.co.example.form.SelectForm;
import jp.co.example.service.PartyService;

/*
 * 検索画面コントローラ
 */
@Controller
public class SelectController {

    /*
     * messages_ja.propertiesのメッセージ取得用
     */
    @Autowired
    MessageSource messageSource;

    @Autowired
    HttpSession session;

    /*
     * ユーザ情報サービス
     */

    @Autowired
    private PartyDao partyDao;

    @Autowired
    private JoinDao joinDao;


    @Autowired
    private PartyService partyService;

    /*
     * 検索画面表示
     */
    @RequestMapping("/select")
    public String select(@ModelAttribute("selectForm") SelectForm form, Model model) {
        return "select";
    }

    /*
     * 検索結果画面表示 (検索画面の検索ボタン押下時)
     */
    @RequestMapping(value = "/list")
    public String list(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "select";
        }


        // 検索処理
        Party party = partyDao.findByNameAndPassword(form.getPartyName(),form.getPass());
        List<Join> resultList = joinDao.findByName(form.getPartyName());

        if (party == null) {
            // 検索結果が無い場合
            String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
            model.addAttribute("errMsg", errMsg);
            return "select";
        } else {
            // 検索結果がある場合

            session.setAttribute("party", party);

            model.addAttribute("joinlist", resultList);

            return "selectResult";
        }


    }




    @RequestMapping("/createParty")
    public String create(@ModelAttribute("selectForm") SelectForm form, Model model) {
        return "createParty";
    }


    @RequestMapping(value = "/createConfirm", method = RequestMethod.POST)
    public String insertConfirm(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,
            Model model) {



        if (bindingResult.hasErrors()) {
            return "createParty";
        }

        // 入力値をEntityにセット
        Party party = new Party(null,form.getPartyName(),form.getPass(),form.getPartyDate(),form.getPartyPlace(),form.getPartyCome());

        // セッション情報を取得




        session.setAttribute("createParty", party);

        System.out.println(party.getPartyName());
        System.out.println(party.getPartyDate());


        // ID重複チェック
        if (partyService.existsPartyByName(form.getPartyName())) {
            // login_idが重複していた場合
            String errMsg = messageSource.getMessage("id.duplicate.error", null, Locale.getDefault());
            model.addAttribute("errMsg", errMsg);
            return "createParty";
        }

        return "createConfirm";
    }

    @RequestMapping(value = "/create", params = "create", method = RequestMethod.POST)
    public String insertExecute(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,
            Model model) {



        // セッションに保存したユーザ情報を取得
        Party party = (Party) session.getAttribute("createParty");


        System.out.println(party.getPartyName());
        System.out.println(party.getPartyPass());

        if (!party.getPartyPass().equals(form.getConfirmPass())) {
            // 再入力パスワードが一致しない場合
            String errMsg = messageSource.getMessage("password.not.match.error", null, Locale.getDefault());
            model.addAttribute("errMsg", errMsg);

            form.setConfirmPass("");

            return "createConfirm";
        }

        // 登録処理
        partyService.insert(party);

        // 登録用データをセッションから破棄
        session.removeAttribute("userInfo");


        return "createResult";
    }

    @RequestMapping(value = "/create", params = "back", method = RequestMethod.POST)
    public String insertBack(@ModelAttribute("selectForm") SelectForm form, Model model) {


        // セッションに保存したユーザ情報を取得し、フォームにセット
        Party party = (Party) session.getAttribute("createParty");

        form.setPass(party.getPartyPass());

        return "createParty";
    }


}
