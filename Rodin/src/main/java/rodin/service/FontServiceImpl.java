package rodin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rodin.repository.mapper.FontMapper;
import rodin.repository.vo.FontVo;

@Service("fontService")
public class FontServiceImpl implements FontService {
	private static final Logger logger = LoggerFactory.getLogger(FontServiceImpl.class);
	
	@Autowired
	FontMapper fontMapper;

	@Override
	public FontVo getFontInfo(String fontName) {
		logger.debug("Get Font Infomation At Service");
		FontVo fvo = fontMapper.selectFontByFontname(fontName);
		return fvo;
	}

}
