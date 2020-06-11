package jp.co.example.controller;

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

import jp.co.example.entity.SessionInfo;
import jp.co.example.entity.UserInfo;
import jp.co.example.form.LoginForm;
import jp.co.example.service.UserInfoService;
import jp.co.example.util.ParamUtil;

/*
 * ログイン画面周りコントローラ
 */
@Controller
public class AuthController {

    /*
     * messages_ja.propertiesのメッセージ取得用
     */
    @Autowired
    MessageSource messageSource;

    /*
     * セッション情報
     */
    @Autowired
    HttpSession session;

    /*
     * user_infoテーブル
     */
    @Autowired
    private UserInfoService userInfoService;

    /*
     * ログイン画面遷移
     */
    @RequestMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm form, Model model) {
        return "login";
    }

    /*
     * ログイン処理 (ログイン画面のログインボタン押下)
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult,
            Model model) {

        String errMsg = messageSource.getMessage("login.error", null, Locale.getDefault());

        if (bindingResult.hasErrors()) {
            return "login";
        }

        UserInfo user = userInfoService.authentication(form.getLoginId(), form.getPassword());

        if (user == null) {
            // ログイン失敗
            model.addAttribute("errMsg", errMsg);
            return "login";
        } else {
            // ログイン成功

            // role一覧を取得
           // List<Role> roleList = roleService.findAll();

            // ログインユーザ情報、role一覧をセッションにセット
            SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);

            sessionInfo.setLoginUser(user);
           // sessionInfo.setRoleList(roleList);

            session.setAttribute("sessionInfo", sessionInfo);

            return "menu";
        }
    }

    /*
     * ログアウト
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(Model model) {
        session.invalidate();
        return "logout";
    }
}
