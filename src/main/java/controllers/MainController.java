package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hibernate.Pics;
import hibernate.User;
import util.HibernateUtil;

@Controller
public class MainController {
	@Autowired
	HibernateManager HM;
	
	@RequestMapping("/signup")
	public String boo1(Model model,@RequestParam("fname")String fname , @RequestParam("lname") String lname ,
			@RequestParam("pass") String password,@RequestParam("email")String email)
	{
		User ME=new User(fname,lname,password,email);
	    HM.save(ME);
		Session session = HibernateUtil.getSessionFactory().openSession();
	    List<Pics> prod = session.createQuery(String.format("from Pics where picId=")+ME.getId(), Pics.class).list();
	    model.addAttribute("fname",fname.toUpperCase());
	    model.addAttribute("prod",prod);
	    model.addAttribute("id",ME.getId());

    	return "cards.jsp";
	    
	}
	@RequestMapping("/store")
	public String boo3(Model model,@RequestParam("id")int picId, @RequestParam("description") String desc, 
			@RequestParam("pic") MultipartFile pic,@RequestParam("fname")String fname) throws UnsupportedEncodingException
	{
		StringBuilder fileNames = new StringBuilder();
		  Path fileNameAndPath = Paths.get(pic.getOriginalFilename());
		  fileNames.append(pic.getOriginalFilename()+" ");
		  try {
			Files.write(fileNameAndPath, pic.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(fileNameAndPath.toString());
		byte[] imageData = new byte[(int) file.length()];
		try {
		    FileInputStream fileInputStream = new FileInputStream(file);
		    fileInputStream.read(imageData);
		    fileInputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		/*byte[] encodeBase64 = Base64.getEncoder().encode(imageData);
	    String base64Encoded = new String(encodeBase64, "UTF-8");*/
		String string = pic.getName();
		Pics as=new Pics(picId,pic.getOriginalFilename().toString(),desc,imageData);
		HM.savePic(as);
		Session session = HibernateUtil.getSessionFactory().openSession();
	    List<Pics> prod = session.createQuery(String.format("from Pics where picId=")+picId, Pics.class).list();
	    model.addAttribute("fname",fname.toUpperCase());
	    model.addAttribute("prod",prod);
	    model.addAttribute("id",picId);
	    string =string.substring(string.length() - 1);
	    model.addAttribute("check",string);
	    return "cards.jsp";
	    
	}
	@RequestMapping("/session")
	public String boo4(Model model)
	{
		
		return null;
	}
	@RequestMapping("/login")
	public String boo1(Model model,@RequestParam("pass") String password,@RequestParam("email")String email )
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
	    List<User> user = session.createQuery(String.format("from User"), User.class).list();
	    for (User m:user) {
	    if (password.equals(m.getPassword()) && email.equals(m.getEmail())) {
		    List<Pics> prod = session.createQuery(String.format("from Pics where picId=")+m.getId(), Pics.class).list();
		    model.addAttribute("fname",m.getFirstName().toUpperCase());
	    	model.addAttribute("prod",prod);
	    	model.addAttribute("id",m.getId());
	    	System.out.println(m.getId());
	    	return "cards.jsp";
	    }
	    }
	  
    	model.addAttribute("msg","your password or email is wrong ");
	    return "login.jsp";
	    
	}

	@RequestMapping("delete")
	public String boo4(Model model,@RequestParam("id") int id,@RequestParam("picId") int picId,@RequestParam("fname") String fname )
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Pics Pr=new Pics();
        Pr.setId(id);
        Pr=(Pics) session.get(Pics.class,id);
        session.delete(Pr);
        session.getTransaction().commit();
	    List<Pics> prod = session.createQuery(String.format("from Pics where picId=")+picId).list();
	    session.close();
	    model.addAttribute("fname",fname.toUpperCase());
	    model.addAttribute("prod",prod);
	    model.addAttribute("id",id);
	    return "cards.jsp";
	}
}

