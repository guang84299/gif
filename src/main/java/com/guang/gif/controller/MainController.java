package com.guang.gif.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guang.gif.mapper.ArticleMapper;
import com.guang.gif.mapper.CommentMapper;
import com.guang.gif.mapper.CommentLoveMapper;
import com.guang.gif.mapper.LoveMapper;
import com.guang.gif.mapper.TagMapper;
import com.guang.gif.mapper.UserMapper;
import com.guang.gif.pojo.Article;
import com.guang.gif.pojo.ArticleExample;
import com.guang.gif.pojo.Comment;
import com.guang.gif.pojo.CommentExample;
import com.guang.gif.pojo.CommentLove;
import com.guang.gif.pojo.CommentLoveExample;
import com.guang.gif.pojo.Love;
import com.guang.gif.pojo.LoveExample;
import com.guang.gif.pojo.Tag;
import com.guang.gif.pojo.TagExample;
import com.guang.gif.pojo.User;
import com.guang.gif.pojo.UserExample;
import com.guang.gif.tools.GAutoTool;
import com.guang.gif.tools.GTools;
import com.guang.gif.tools.PinYinTools;
import com.guang.gif.tools.SensitivewordFilter;



@Controller
@RequestMapping("/")
public class MainController {

	@Resource
    private ArticleMapper articleMapper;
	@Resource
	private LoveMapper loveMapper;
	@Resource
	private CommentMapper commentMapper;
	@Resource
	private CommentLoveMapper commentLoveMapper;
	@Resource
	private TagMapper tagMapper;
	@Resource
	private UserMapper userMapper;
	
	
	@RequestMapping("/")
    public String index(Model model,HttpServletRequest request) {
		showModel(null,null,model,request);
		model.addAttribute("home", true);
        return "index";  
    }
	
	@RequestMapping("/{id}.htm")
    public String show(@PathVariable Long id,Model model,HttpServletRequest request) {
		Article curr = articleMapper.selectByPrimaryKey(id);
		showModel(curr,null,model,request);
        return "index";  
    }
	
	@RequestMapping("/{tag}.html")
    public String show(@PathVariable String tag,Model model,HttpServletRequest request) {
		showModel(null,tag,model,request);
        return "index";  
    }
	
	@RequestMapping("/{tag}/{id}.htm")
    public String show(@PathVariable String tag,@PathVariable Long id,Model model,HttpServletRequest request) {
		//当前Article
		Article curr = articleMapper.selectByPrimaryKey(id);    
        showModel(curr,tag,model,request);
        return "index";  
    }
	
	public void showModel(Article curr,String tag,Model model,HttpServletRequest request)
	{
		String ip = request.getRemoteAddr();
		Tag currTag = null;
		if(tag != null)
		{
			if(!"hot".equals(tag))
			{
				TagExample tagExample = new TagExample();
				tagExample.createCriteria().andNamePyEqualTo(tag);
				List<Tag> tags = tagMapper.selectByExample(tagExample);
				if(tags.size()>0)
				{
					currTag = tags.get(0);
				}
			}			
		}
		if(curr == null)
		{
			ArticleExample articleExample = new ArticleExample();
			if(currTag != null)
				articleExample.createCriteria().andTagIdEqualTo(currTag.getId());
			int count = articleMapper.countByExample(articleExample)-1;
			if(count<0) count = 0;
	        
	        //随机一个值
	        int index = (int) (Math.random()*100%count);
	        articleExample.setLimitIndex(index);
	        articleExample.setOrderByClause("id desc");
	        articleExample.setLimitNum(3);
	        articleExample.createCriteria().andGreleaseEqualTo(true);
	        List<Article> list = articleMapper.selectByExample(articleExample);
	        Article pre = null;
	        Article next = null;
	        if(list.size() == 3)
	        {
	        		curr = list.get(1);
	        		pre = list.get(0);
	        		next = list.get(2);
	        }
	        else if(list.size() == 2)
	        {
		        	curr = list.get(0);
		    		next = list.get(1);
		    }
	        else if(list.size() == 1)
	        {
	        		curr = list.get(0);
		    }
	        model.addAttribute("pre", pre);
	        model.addAttribute("next", next);
		}
		else
		{
			ArticleExample articleExample = new ArticleExample();
			//下一个
	        articleExample.setOrderByClause("id desc");
	        articleExample.setLimitNum(1);
	        if(currTag != null)
	        {
	        		articleExample.createCriteria().andGreleaseEqualTo(true)
	            .andIdLessThan(curr.getId()).andTagIdEqualTo(currTag.getId());
	        }
	        else
	        {
	        		articleExample.createCriteria().andGreleaseEqualTo(true)
	            .andIdLessThan(curr.getId());
	        }
	        List<Article> list = articleMapper.selectByExample(articleExample);
	        if(list.size()>0)
	        	model.addAttribute("next", list.get(0));
	        
	        //上一个
	        articleExample = new ArticleExample();
	        articleExample.setLimitNum(1);
	        if(currTag != null)
	        {
	        		articleExample.createCriteria().andGreleaseEqualTo(true)
	            .andIdGreaterThan(curr.getId()).andTagIdEqualTo(currTag.getId());
	        }
	        else
	        {
	        		articleExample.createCriteria().andGreleaseEqualTo(true)
	            .andIdGreaterThan(curr.getId());
	        }
	        list = articleMapper.selectByExample(articleExample);
	        if(list.size()>0)
	        	model.addAttribute("pre", list.get(0));
		}
		
		
		//当前文章是否喜欢
        LoveExample loveExample = new LoveExample();
        loveExample.createCriteria().andArticleIdEqualTo(curr.getId())
        .andIpEqualTo(ip);
        int loveNum = loveMapper.countByExample(loveExample);
        curr.setMeLove(loveNum>0);
		model.addAttribute("curr", curr);
		
		ArticleExample articleExample = new ArticleExample();
		//大家都在看
        articleExample = new ArticleExample();
        articleExample.setOrderByClause("show_num desc");
        articleExample.setLimitNum(6);
        articleExample.createCriteria().andGreleaseEqualTo(true);
        List<Article> list_love = articleMapper.selectByExample(articleExample);
        model.addAttribute("list_love", list_love);
        
        //相关推荐
        articleExample = new ArticleExample();
        articleExample.createCriteria().andGreleaseEqualTo(true)
        .andTagIdEqualTo(curr.getTagId());
        
        int num = articleMapper.countByExample(articleExample);
        int index = (int) (Math.random()*100%num);
        articleExample.setOrderByClause("show_num desc");
        articleExample.setLimitIndex(index);
        articleExample.setLimitNum(8);
        List<Article> list_tuijian = articleMapper.selectByExample(articleExample);
        List<Article> list_tuijian1 = new ArrayList<>();
        List<Article> list_tuijian2 = new ArrayList<>();
        for(int i=0;i<list_tuijian.size();i++)
        {
        		if(i%2==0)
        		{
        			list_tuijian1.add(list_tuijian.get(i));
        		}
        		else
        		{
        			list_tuijian2.add(list_tuijian.get(i));
        		}
        }
        model.addAttribute("list_tuijian1", list_tuijian1);
        model.addAttribute("list_tuijian2", list_tuijian2);
        
        //获取热门标签
        TagExample tagExample = new TagExample();
        tagExample.setOrderByClause("show_num desc");
        tagExample.setLimitNum(16);
        List<Tag> list_tag = tagMapper.selectByExample(tagExample);
        model.addAttribute("list_tag", list_tag);
        
        //当前文章标签
        Tag ctag = tagMapper.selectByPrimaryKey(curr.getTagId());
        model.addAttribute("tag", ctag);
        
        //当前文章评论
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("love_num desc");
        commentExample.setLimitNum(5);
        commentExample.createCriteria().andArticleIdEqualTo(curr.getId());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        //当前评论是否喜欢
        for(Comment comment : comments)
        {
        		CommentLoveExample commentLoveExample = new CommentLoveExample();
            commentLoveExample.createCriteria().andCommentIdEqualTo(comment.getId())
            .andIpEqualTo(ip);
            int commentLoveNum = commentLoveMapper.countByExample(commentLoveExample);
            comment.setMeLove(commentLoveNum>0);
            comment.initXip();
        }
        model.addAttribute("comments", comments);
        
        //是否有更多评论
        model.addAttribute("more", comments.size()==5);
        
        //当前路径标签
        if(tag != null)
        model.addAttribute("pathtag", tag+"/");
        
        model.addAttribute("ip", ip);
        
        //更新文章和标签的显示次数
        curr.setShowNum(curr.getShowNum()+1);
        articleMapper.updateByPrimaryKeySelective(curr);
        if(currTag != null)
        {
        		currTag.setShowNum(currTag.getShowNum()+1);
        		tagMapper.updateByPrimaryKeySelective(currTag);
        }
	}
	
	@RequestMapping("/love")
    public void love(@RequestParam Long id,HttpServletRequest request,HttpServletResponse response)
    {
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article != null)
		{
			String ip = request.getRemoteAddr();
			LoveExample loveExample = new LoveExample();
			loveExample.createCriteria().andArticleIdEqualTo(id).andIpEqualTo(ip);
			List<Love> loves = loveMapper.selectByExample(loveExample);
			if(loves != null && loves.size() > 0)
			{
				loveMapper.deleteByPrimaryKey(loves.get(0).getId());
				article.setLoveNum(article.getLoveNum()-1);
				articleMapper.updateByPrimaryKeySelective(article);
			}
			else
			{
				Love love = new Love();
				love.setArticleId(id);
				love.setIp(ip);
				loveMapper.insert(love);
				article.setLoveNum(article.getLoveNum()+1);
				articleMapper.updateByPrimaryKeySelective(article);
			}
			print(response,true);
		}
		else
		{
			print(response,false);
		}
    }
	
	@RequestMapping("/comment")
    public @ResponseBody List<Comment> comment(@RequestBody Comment comment,HttpServletRequest request)
    {
		Article article = articleMapper.selectByPrimaryKey(comment.getArticleId());
		if(article != null)
		{
			String ip = request.getRemoteAddr();
			
			CommentExample commentExample = new CommentExample();
			commentExample.createCriteria().andArticleIdEqualTo(article.getId());
			long floor = commentMapper.countByExample(commentExample)+1;
			
			comment.setFloor(floor);
			comment.setIp(ip);
			comment.setLoveNum(0l);
			comment.setcDate(new Date());
			comment.initXip();
			
			SensitivewordFilter filter =  SensitivewordFilter.getInstance();
			String content = filter.replaceSensitiveWord(comment.getContent(), 1, "*");
			comment.setContent(content);
			
			commentMapper.insertSelective(comment);
			
			article.setCommentNum(article.getCommentNum()+1);
			articleMapper.updateByPrimaryKeySelective(article);
		}
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		return comments;
    }
	
	
	@RequestMapping("/morecomment")
    public @ResponseBody List<Comment> morecomment(@RequestParam Long id,@RequestParam Integer index,HttpServletRequest request)
    {
		String ip = request.getRemoteAddr();
		
		CommentExample commentExample = new CommentExample();
		commentExample.setOrderByClause("love_num desc");
		commentExample.setLimitIndex(index);
	    commentExample.setLimitNum(5);
		commentExample.createCriteria().andArticleIdEqualTo(id);
		List<Comment> comments = commentMapper.selectByExample(commentExample);
		
		//当前评论是否喜欢
        for(Comment comment : comments)
        {
        		CommentLoveExample commentLoveExample = new CommentLoveExample();
            commentLoveExample.createCriteria().andCommentIdEqualTo(comment.getId())
            .andIpEqualTo(ip);
            int commentLoveNum = commentLoveMapper.countByExample(commentLoveExample);
            comment.setMeLove(commentLoveNum>0);
            comment.initXip();
        }
		
		return comments;
    }
	
	@RequestMapping("/commentlove")
    public void commentlove(@RequestParam Long id,HttpServletRequest request,HttpServletResponse response)
    {
		Comment comment = commentMapper.selectByPrimaryKey(id);
		if(comment != null)
		{
			String ip = request.getRemoteAddr();
			CommentLoveExample commentLoveExample  = new CommentLoveExample();
			commentLoveExample.createCriteria().andCommentIdEqualTo(id).andIpEqualTo(ip);
			List<CommentLove> commentLoves = commentLoveMapper.selectByExample(commentLoveExample);
			if(commentLoves != null && commentLoves.size() > 0)
			{
				commentLoveMapper.deleteByPrimaryKey(commentLoves.get(0).getId());
				comment.setLoveNum(comment.getLoveNum()-1);
				commentMapper.updateByPrimaryKeySelective(comment);
			}
			else
			{
				CommentLove commentLove = new CommentLove();
				commentLove.setCommentId(id);
				commentLove.setIp(ip);
				commentLoveMapper.insert(commentLove);
				comment.setLoveNum(comment.getLoveNum()+1);
				commentMapper.updateByPrimaryKeySelective(comment);
			}
			print(response,true);
		}
		else
		{
			print(response,false);
		}
    }
	
	@RequestMapping("/admin")
    public String admin(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null)
			return "login";
		
		String index = request.getParameter("index");
		int page = 0;
		if(index != null)
		{
			page = Integer.parseInt(index)-1;
		}
		int num = (int) articleMapper.countByExample(null);
		if(num%100 != 0)
			num = num/100 + 1;
		else
			num = num / 100;
		
		ArticleExample articleExample = new ArticleExample();
		articleExample.setOrderByClause("id desc");
		articleExample.setLimitIndex(page*100);
		articleExample.setLimitNum(100);
		List<Article> list = articleMapper.selectByExample(articleExample);
		
		model.addAttribute("list",list);
		model.addAttribute("page",page+1);
		model.addAttribute("num",num);
        return "admin";  
    }
	
	@RequestMapping("/login")
    public String login(@RequestParam String name,@RequestParam String password,HttpServletRequest request) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(userExample);
		if(list.size()>0)
		{
			request.getSession().setAttribute("user", list.get(0));
		}
        return "redirect:/admin";  
    }
	
	@RequestMapping("/add")
    public String add(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null)
			return "login";
		List<Tag> tags = tagMapper.selectByExample(new TagExample());
		model.addAttribute("tags",tags);
        return "add";  
    }
	
	@RequestMapping("/addTag")
    public @ResponseBody Tag addTag(@RequestBody Tag tag) {
		tag.setShowNum(0l);
		tag.setNamePy(PinYinTools.getPinYin(tag.getName()).toLowerCase());
		tagMapper.insertSelective(tag);
		return tag;
    }
	
	@RequestMapping("/addArticle")
    public void addArticle(@RequestBody Article article,HttpServletResponse response) {
		article.setCommentNum(0l);
		article.setGrelease(true);
		article.setLoveNum(0l);
		article.setShowNum(0l);
		article.setcDate(new Date());
		article.setHeadPath(article.getPicPath().substring(0,article.getPicPath().lastIndexOf("."))+".jpg");
		articleMapper.insertSelective(article);
		print(response,true);
    }
	
	@RequestMapping("/toUpdate")
    public String toUpdate(@RequestParam Long id,Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null)
			return "login";
		Article article = articleMapper.selectByPrimaryKey(id);
		model.addAttribute("article", article);
		List<Tag> tags = tagMapper.selectByExample(new TagExample());
		model.addAttribute("tags",tags);
        return "update";  
    }
	
	@RequestMapping("/updateArticle")
    public void updateArticle(@RequestBody Article article,HttpServletResponse response) {
		Article a = articleMapper.selectByPrimaryKey(article.getId());
		a.setTitle(article.getTitle());
		a.setKeywords(article.getKeywords());
		a.setTagId(article.getTagId());
		a.setPicPath(article.getPicPath());
		a.setHeadPath(article.getPicPath().substring(0,article.getPicPath().lastIndexOf("."))+".jpg");
		articleMapper.updateByPrimaryKeySelective(a);
		print(response,true);
    }
	
	@RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestParam Long id,HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null)
			return "login";
		LoveExample loveExample = new LoveExample();
		loveExample.createCriteria().andArticleIdEqualTo(id);
		loveMapper.deleteByExample(loveExample);
		
		CommentExample commentExample = new CommentExample();
		commentExample.createCriteria().andArticleIdEqualTo(id);
		List<Comment> comments = commentMapper.selectByExample(commentExample);
		for(Comment comment : comments)
		{
			CommentLoveExample commentLoveExample = new CommentLoveExample();
			commentLoveExample.createCriteria().andCommentIdEqualTo(comment.getId());
			commentLoveMapper.deleteByExample(commentLoveExample);
		}
		commentMapper.deleteByExample(commentExample);
		articleMapper.deleteByPrimaryKey(id);
        return "redirect:/admin"; 
    }
	
	@RequestMapping("/releaseArticle")
    public String releaseArticle(@RequestParam Long id,HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null)
			return "login";
		Article a = articleMapper.selectByPrimaryKey(id);
		a.setGrelease(!a.getGrelease());
		articleMapper.updateByPrimaryKeySelective(a);
        return "redirect:/admin"; 
    }
	
	@RequestMapping("/commentAdmin")
    public String commentAdmin(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null)
			return "login";
		
		String id = request.getParameter("id");
		String index = request.getParameter("index");
		long tid = Long.parseLong(id);
		int page = 0;
		if(index != null)
		{
			page = Integer.parseInt(index)-1;
		}
		CommentExample commentExample = new CommentExample();
		commentExample.createCriteria().andArticleIdEqualTo(tid);
		int num = (int) commentMapper.countByExample(commentExample);
		if(num%100 != 0)
			num = num/100 + 1;
		else
			num = num / 100;
		
		commentExample = new CommentExample();
		commentExample.setOrderByClause("id desc");
		commentExample.setLimitIndex(page*100);
		commentExample.setLimitNum(100);
		commentExample.createCriteria().andArticleIdEqualTo(tid);
		List<Comment> list = commentMapper.selectByExample(commentExample);
		
		model.addAttribute("list",list);
		model.addAttribute("page",page+1);
		model.addAttribute("num",num);
		model.addAttribute("aid",id);
        return "commentAdmin";  
    }
	
	@RequestMapping("/deleteComment")
    public String deleteComment(@RequestParam Long id,@RequestParam Long cid,HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null)
			return "login";
		Comment comment = commentMapper.selectByPrimaryKey(cid);
		if(comment!=null)
		{
			CommentLoveExample commentLoveExample = new CommentLoveExample();
			commentLoveExample.createCriteria().andCommentIdEqualTo(cid);
			commentLoveMapper.deleteByExample(commentLoveExample);
			
			commentMapper.deleteByPrimaryKey(cid);
			
			Article article = articleMapper.selectByPrimaryKey(id);
			if(article != null)
			{
				article.setCommentNum(article.getCommentNum()-1);
				articleMapper.updateByPrimaryKeySelective(article);
			}
		}
        return "redirect:/commentAdmin?id="+id; 
    }
	
	@RequestMapping("/uploadFile")
    public void uploadFile(MultipartFile pic,HttpServletRequest request,HttpServletResponse response) {
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		DateFormat formatDir = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatFile = new SimpleDateFormat("HHmmssSS");
		
		File dir = new File(GTools.getUploadDir() + formatDir.format(new Date()));
		if(!dir.exists())
			dir.mkdirs();		
		//保存图片到 
		String name = dir.getAbsolutePath() + "/" +formatFile.format(new Date()) + "." + ext;
		File saveFile = null;
		try {
			saveFile = new File(name);
			pic.transferTo(saveFile);
			GTools.tozipPic(name, name.substring(0,name.lastIndexOf("."))+".jpg");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(saveFile == null || !saveFile.exists())
			 name = "";
		else
		{
			name = name.substring(name.indexOf("gif")+3,name.length());
		}
		print(response,name);
    }
	
	@RequestMapping("/autoAdd")
    public void autoAdd(@RequestParam String url,HttpServletRequest request,HttpServletResponse response)
    {
		GAutoTool.autoAdd(url);
		print(response,true);
    }
	
	public void print(HttpServletResponse response,Object obj)
	{
		try {
			PrintWriter writer = response.getWriter();
			writer.print(obj);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getRealPath(HttpServletRequest request,String path)
	{
		return request.getSession().getServletContext().getRealPath(path);
	}
}
