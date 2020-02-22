package rodin.repository.mapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import rodin.config.AbstractDao;
import rodin.repository.vo.FontVo;

@Repository("fontMapper")
public class FontMapper extends AbstractDao {
	private static final Logger logger = LoggerFactory.getLogger(FontMapper.class);
    
    public FontVo selectFontByFontname(String fontName) {
    	logger.debug("Get Font Information From DB");
    	FontVo fvo = (FontVo) selectOne("font.selectFontByFontname");
    	return fvo;
    }
 }
