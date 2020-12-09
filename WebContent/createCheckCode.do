@RequestMapping("createCheckCode")
@ResponseBody
public void createCheckCode(HttpServletRequest request,HttpServletResponse response) {
        // 设置页面不缓存
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("image/gif");
	// 生成的图片
	CheckCodeImageUtil img = new CheckCodeImageUtil();
	BufferedImage image = img.createImage();
	
	//可将生成的验证码存入缓存 同时设置过期时间,用于验证码校验
	String checkCode = img.getRandString();
	
	OutputStream out = null;
	try {
		// Servlet输出流
		out = response.getOutputStream();
		// 将图片写入到输出流中去
		ImageIO.write(image, "JPG", out);
		// 强制刷新
		out.flush();
		// 关闭输出流
		out.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}