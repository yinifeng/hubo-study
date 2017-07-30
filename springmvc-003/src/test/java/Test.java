import net.sf.json.JSONObject;


public class Test {
	public static void main(String[] args) {
		WechatTemplate wt=new WechatTemplate();
		wt.setTouser("st123456");
		wt.setTemplate_id("sdfsdddddd");
		wt.setTopcolor("#000FF45");
		wt.setUrl("http://music.163.com/#/song?id=27867140");
		wt.getData().put("first", new TemplateData("交易信息", "#000F3"));
		wt.getData().put("keyword1", new TemplateData("牛肉面", "#000F3"));
		wt.getData().put("keyword2", new TemplateData("20.00元", "#000F3"));
		wt.getData().put("remark", new TemplateData("更多信息", "#000F3"));
		
		System.out.println(JSONObject.fromObject(wt));
		
		
	}
}
