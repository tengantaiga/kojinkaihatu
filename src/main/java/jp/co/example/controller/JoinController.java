package jp.co.example.controller;

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
import jp.co.example.entity.Join;
import jp.co.example.entity.Party;
import jp.co.example.entity.SessionInfo;
import jp.co.example.entity.UserInfo;
import jp.co.example.form.InsertForm;
import jp.co.example.util.ParamUtil;

@Controller
public class JoinController {

	 @Autowired
	    MessageSource messageSource;

	 @Autowired
	    HttpSession session;

	 @Autowired
	    private JoinDao joinDao;

	 @RequestMapping(value = "/join",method = RequestMethod.POST)
	    public String insertExecute(@Validated @ModelAttribute("insertForm") InsertForm form, BindingResult bindingResult,
	            Model model) {



	        // セッションに保存したユーザ情報を取得
	        Party party = (Party) session.getAttribute("party");
	        SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);

	        UserInfo user  = sessionInfo.getLoginUser();

	        String loginId = user.getLoginId();
	        String partyName = party.getPartyName();

	        Join join = new Join();
	        join.setLoginId(loginId);
	        join.setPartyName(partyName);


	        // 登録処理
	        joinDao.insert(join);

	        // 登録用データをセッションから破棄
	        session.removeAttribute("userInfo");


	        return "menu";
	    }




}
