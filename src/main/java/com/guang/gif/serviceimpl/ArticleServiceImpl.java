package com.guang.gif.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import com.guang.gif.mapper.ArticleMapper;
import com.guang.gif.pojo.Article;
import com.guang.gif.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	@Resource
    private ArticleMapper articleMapper;
	
	private List<Article> lists = new ArrayList<>();
//	private int max = 5;
	@Override
	public Article findById(long id) {
		Article article = null;
		for(Article a : lists)
		{
			if(a.getId() == id)
			{
				article = a;
				break;
			}
		}
		if(article == null)
		{
			article = articleMapper.selectByPrimaryKey(id);
			lists.add(article);
			System.out.println(lists.size());
			
			
		}
		return article;
	}

	
	public void validateMax()
	{
		
	}
}
