package com.bjgt.ms.action;

import javax.servlet.ServletOutputStream;

import net.sf.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjgt.ms.action.base.CrudActionSupport;
import com.bjgt.ms.entity.TspdmImage;
import com.bjgt.ms.service.TspdmImageManager;
import com.bjgt.ms.util.Constants;

/**
 * 商品分类表
 * 
 * @author tom
 * 
 */
@Controller
@RequestMapping(value = "spdmimage")
public class TmspdmImageQueryAction extends CrudActionSupport<TspdmImage> {
	@Autowired
	private TspdmImageManager tspdmImageManager;

	/**
	 * 获取图片流
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "getimage.html", method = { RequestMethod.GET })
	public synchronized void getImage() throws Exception {
		String page = request.getParameter(Constants.PAGE);
		TspdmImage tspdm = null;
		// 查询
		tspdm = tspdmImageManager.get(page);
		if (tspdm == null) {
			return;
		}
		byte[] fimage = tspdm.getSpimage();
		// FileUtil.byte2File(fimage, "F:", "22.jpg");
		ServletOutputStream out = response.getOutputStream();
		// 输出图片流
		out.write(fimage);
		out.close();
	}

	/**
	 * 跳转到分类表界面
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "tospdmimg.html", method = { RequestMethod.POST })
	public String toSpdmImg() throws Exception {
		Integer page = Integer.valueOf(request.getParameter(Constants.PAGE));
		modelMap.put("page", page);
		return "/tmweb/spdmimg";
	}

	/**
	 * 跳转到分类表界面
	 * 
	 * @author tom
	 * @throws JSONException
	 */
	@RequestMapping(value = "mtospdmimg.html", method = { RequestMethod.POST })
	public String mtoSpdmImg() throws Exception {
		Integer page = Integer.valueOf(request.getParameter(Constants.PAGE));
		modelMap.put("page", page);
		return "/tm/spdmimg";
	}

}
