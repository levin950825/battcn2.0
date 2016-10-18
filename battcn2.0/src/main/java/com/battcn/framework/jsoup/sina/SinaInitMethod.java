package com.battcn.framework.jsoup.sina;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: SinaInitMethod
 * @author 唐亚峰
 * @date 2016年10月17日
 */
public class SinaInitMethod
{

	/**
	 * 接口调用 GET
	 */
	public static String getSinaReview(String urlStr,String cookie)
	{
		StringBuilder sb = new StringBuilder();
		try
		{
			URL url = new URL(urlStr); // 把字符串转换为URL请求地址
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Cookie",cookie);
			connection.connect();// 连接会话
			// 获取输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;

			while ((line = br.readLine()) != null)
			{// 循环读取流
				sb.append(line);
			}
			br.close();// 关闭流
			connection.disconnect();// 断开连接
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("失败!");
		}
		return sb.toString();
	}

	public static List<SinaReview> sina(String id,int page,String cookie)
	{
		//这里的地址,需要玩爬虫的自己去找个微博博主的微博点开就有了,为了被封号 我肯定不敢吧自己的提供给你们,Cookie会开发的都会用浏览器Copy出来O(∩_∩)O哈哈~
		String url = "http://weibo.com/aj/v6/comment/big?ajwvr=6&id="+id+"&page=" + page;
		String review = getSinaReview(url,cookie);
		JSONObject json = JSON.parseObject(review);
		JSONObject data = json.getJSONObject("data");
		// System.out.println(data);
		// Integer count = data.getInteger("count");
		// JSONObject page = data.getJSONObject("page");
		// Integer pageNum = page.getInteger("pagenum");
		// Integer totalPage = page.getInteger("totalpage");
		String html = data.getString("html");
		Document doc = Jsoup.parse(html);
		Elements ee = doc.getElementsByAttribute("comment_id");
		List<SinaReview> list = new ArrayList<SinaReview>();
		SinaReview sinaReview = null;
		for (Element el : ee)
		{
			sinaReview = new SinaReview();
			String commentId = Jsoup.parse(el.outerHtml()).getElementsByTag("div").attr("comment_id");
			Element efl = el.getElementsByClass("W_fl").first();
			String commentUrl = efl.getElementsByTag("a").attr("abs:href");
			String image = efl.getElementsByTag("img").attr("src");
			String userCard = efl.getElementsByTag("img").attr("usercard");
			String comment = el.getElementsByClass("WB_text").first().text();
			sinaReview.setBlog("邓超");
			sinaReview.setCommentId(commentId);
			sinaReview.setCommentUrl(commentUrl);
			sinaReview.setComment(comment);
			sinaReview.setImage(image);
			sinaReview.setTitle("从你的全世界路过");
			sinaReview.setUserCard(userCard);
			list.add(sinaReview);
		}
		return list;
	}

	public void init()
	{
		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				/*MybatisSqlDao mybatisSqlDao = (MybatisSqlDao) AppContextUtil.getBean("mybatisSqlDaoImpl");
				for (int i = 1; i < 956; i++)
				{
					List<SinaReview> list = sina("1111111111111111",i,"cookie");
					if (list != null && list.size() > 0)
						try
						{
							mybatisSqlDao.batchSave("com.battcn.platform.mapper.sina.SinaMapper.batchAddSina", list);
						} catch (Exception e)
						{
							System.out.println("[error] - [批量添加错误] - [错误信息:]"+e.getMessage());
						}
				}*/
			}
		});
		thread.start();
	}
}
