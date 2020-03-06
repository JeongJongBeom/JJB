package com.jjb.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jjb.model.Criteria;
import com.jjb.model.PageVO;
import com.jjb.model.UserVO;
import com.jjb.service.UserService;

@Controller
//@SessionAttributes({"userid","nickname"})//model�� ���� �� ���ǿ��� ����
@RequestMapping("/user")
public class UserController {
	@Resource
	private String uploadPath;
	
	@Autowired
	private UserService uservice;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() {
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(UserVO uservo, HttpSession session,RedirectAttributes redirect){
		UserVO user = null;
		try {
			user = uservice.login(uservo);
			System.out.println("user : "+user);
			session.setAttribute("userid", user.getUserid());
			
			//�г������� db�����ϸ� �ȵǴ� ���� : �г����� �ߺ��� �Ұ����ϱ��ϳ� ������ �����ϱ⶧����
			session.setAttribute("nickname", user.getNickname());
			session.setAttribute("qualify", user.getQualify());
			session.setAttribute("profileImg", user.getProfileImg());
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addAttribute("msg","1-1");
		}
		
		if(user == null) {
			redirect.addAttribute("msg","1-1");
		}else {
			redirect.addAttribute("msg","1-2");
		}
		return "redirect:/index";

		
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public void singUpGET() {
		
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String singUpPOST(UserVO user) throws Exception {
		System.out.println("ȸ������ ����");
		System.out.println("������ "+user.toString());
		uservice.signUp(user);
		return "redirect:../index";
		//return "redirect:user/login";
	}
	
	@RequestMapping(value="/checkID", method=RequestMethod.GET,produces = "application/json; charset=utf8")
	@ResponseBody//���� ���ϸ� return type��ȯ
	public boolean checkID(String userid) throws Exception {
		System.out.println("checkID ����" );
		String checkid = uservice.checkID(userid);
		System.out.println(checkid);
		if(checkid==null) {//null���̸� db�� ����� ���� ���� -> �ߺ��� ���̵� ����
			return true;
		}else {//�ߺ��Ǵ� ���̵� ����
			return false;
		}		
	}
	
	@RequestMapping(value="/checkNick", method=RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkNick(String nickname) throws Exception {
		System.out.println("checkNick ����");
		return uservice.checkNick(nickname);	
	}
	
	
	@RequestMapping(value="/checkPw", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkPw(String password,HttpSession session) throws Exception{
		System.out.println("üũ�佺���� : "+password);
		String userid = (String)session.getAttribute("userid");
		System.out.println("�������̵�"+userid);
		String rePw = uservice.checkPW(userid);
		System.out.println("return �н����� : "+rePw);
		
		
		return true;
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.invalidate();
		System.out.println("����");
		return "redirect:../index";
	}
	
	@RequestMapping(value="/manage", method=RequestMethod.GET)
	public void manageGET() {
		
	}
	
	@RequestMapping(value="/changeInfo", method=RequestMethod.GET)
	public void changeInfoGET(HttpSession session,Model model) throws Exception {
		//System.out.println("changeInfo��Գ�");
		String userid = (String)session.getAttribute("userid");
		UserVO user = uservice.InfoFromId(userid);
		System.out.println("dd = "+user);
		model.addAttribute("user",user);
		
	}
	
	@RequestMapping(value="/changeInfo",method=RequestMethod.POST)
	public void changeInfoPOST(UserVO user, HttpSession session) throws Exception{
		System.out.println("uservo�� "+user);
		int qualify = (int)session.getAttribute("qualify");
		
		if(qualify == 1) {
			uservice.changeChefInfo(user);
		}else {
			uservice.changeInfo(user);
		}
		
		session.setAttribute("nickname", user.getNickname());
		session.setAttribute("profileImg", user.getProfileImg());
	}
	
	
	@RequestMapping(value="/changePw", method=RequestMethod.GET)
	public void changePwGET() {
		
	}
	
	@RequestMapping(value="/changePw", method=RequestMethod.POST)
	@ResponseBody
	public void changePwPost(String newPw,HttpSession session) throws Exception{
		String userid = (String)session.getAttribute("userid");
		uservice.changePw(newPw, userid);
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public void deleteUserGET() {
		
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteUserPost(String password,HttpSession session) throws Exception{
		String userid = (String)session.getAttribute("userid");
		String reck = uservice.checkPW(userid);
		boolean result = false;
		if(reck.equals(password)) {
			uservice.deleteUser(userid);
			result = true;
		}else {		
			result =  false;
		}
		return result;
	}
	
	@RequestMapping(value="listUser", method=RequestMethod.GET)
	public String listUserGET(Model model,Criteria cri) throws Exception {
		int total =uservice.userCount();
		PageVO pv = new PageVO(cri, total); 
		model.addAttribute("list",uservice.userList(cri));
		model.addAttribute("Page",pv);
		return "admin/userList";
	}
	
	@ResponseBody
	@RequestMapping(value="grantUser", method=RequestMethod.POST)
	public void grantUserPOST(Model model, UserVO user) throws Exception {
		uservice.grantUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value="revokeUser", method=RequestMethod.POST)
	public void revokeUserPOST(Model model, UserVO user) throws Exception {
		uservice.revokeUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value="deleteUser_admin", method=RequestMethod.POST)
	public void deleteUser_adminPOST(Model model, String userid) throws Exception {
		uservice.deleteUser(userid);
	}
	
	@ResponseBody
	@RequestMapping(value = "/GetImgName", method = RequestMethod.POST, produces = "text/palin;charset=utf-8")
	public ResponseEntity<String> talkPost(MultipartFile file, Model model) throws Exception {
		System.out.println("origianlName: " + file.getOriginalFilename());
		System.out.println("size: " + file.getSize());
		System.out.println("contentType: " + file.getContentType());

		return new ResponseEntity<>(com.jjb.util.UploadFileUtils.profileFile(uploadPath,file.getOriginalFilename(),file.getBytes()),HttpStatus.CREATED);

	}
}
