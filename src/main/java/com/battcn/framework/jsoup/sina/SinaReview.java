package com.battcn.framework.jsoup.sina;

import java.util.Date;

/**
 * @ClassName: SinaReview
 * @author 唐亚峰
 * @date 2016年10月14日
 */
public class SinaReview
{
	private Long id;
	private String blog;// 博主
	private String title;// 标题
	private String commentId;// 公共的微博ID
	private String commentUrl;// 用户微博地址
	private String userCard;// 用户标示
	private String image;// 微博用户的头像
	private String comment;// 微博用户的留言
	private Date date;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getBlog()
	{
		return blog;
	}

	public void setBlog(String blog)
	{
		this.blog = blog;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getCommentId()
	{
		return commentId;
	}

	public void setCommentId(String commentId)
	{
		this.commentId = commentId;
	}

	public String getCommentUrl()
	{
		return commentUrl;
	}

	public void setCommentUrl(String commentUrl)
	{
		this.commentUrl = commentUrl;
	}

	public String getUserCard()
	{
		return userCard;
	}

	public void setUserCard(String userCard)
	{
		this.userCard = userCard;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

}
