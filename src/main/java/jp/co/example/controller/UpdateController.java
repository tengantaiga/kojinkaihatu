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

import jp.co.example.dao.PartyDao;
import jp.co.example.entity.Party;
import jp.co.example.form.UpdateForm;

@Controller
public class UpdateController {

	 @Autowired
	    MessageSource messageSource;

	    @Autowired
	    HttpSession session;

	    @Autowired
	    PartyDao partyDao;

	    @RequestMapping("/partyUpdate")
	    public String select(@ModelAttribute("updateForm") UpdateForm form, Model model) {
	        return "partyUpdate";
	    }

	    @RequestMapping(value = "/update")
	    public String list(@Validated @ModelAttribute("updateForm") UpdateForm form, BindingResult bindingResult,
	            Model model) {

	        if (bindingResult.hasErrors()) {
	            return "partyUpdate";
	        }


	        // 検索処理
	        Party party = partyDao.findByNameAndPassword(form.getPartyName(),form.getPass());

	        if (party == null) {
	            // 検索結果が無い場合
	            String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
	            model.addAttribute("errMsg", errMsg);
	            return "partyUpdate";
	        } else {
	            // 検索結果がある場合
	        	form.setPartyDate(party.getPartyDate());
	        	form.setPartyPlace(party.getPartyPlace());
	        	form.setPartyCome(party.getCome());

	            session.setAttribute("party", party);


	            return "update";
	        }


	    }

	    @RequestMapping(value = "/update", params = "update", method = RequestMethod.POST)
	    public String updateExecute(@Validated @ModelAttribute("updateForm") UpdateForm form, BindingResult bindingResult,
	            Model model) {


	        Party party = (Party) session.getAttribute("party");
	        party.setPartyName(form.getPartyName());
	        party.setPartyPass(form.getPass());
	        party.setPartyDate(form.getPartyDate());
	        party.setPartyPlace(form.getPartyPlace());
	        party.setCome(form.getPartyCome());



	        // 更新処理
	        partyDao.update(party);

	        // 更新前/後データをセッションから破棄
	        session.removeAttribute("party");


	        return "updateResult";
	    }

	    @RequestMapping(value = "/delete", params = "back", method = RequestMethod.POST)
	    public String insertBack(@ModelAttribute("updateForm") UpdateForm form, Model model) {




	        return "partyUpdate";
	    }


}
