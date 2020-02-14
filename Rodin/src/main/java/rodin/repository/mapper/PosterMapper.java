package rodin.repository.mapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import rodin.config.AbstractDao;
import rodin.repository.vo.PosterVo;

@Repository("posterMapper")
public class PosterMapper extends AbstractDao {
	private static final Logger logger = LoggerFactory.getLogger(PosterMapper.class);
	
	public int insertPoster(PosterVo pvo) {
        int insertedCount = 0;
        logger.debug("pvo: " + pvo);
        insertedCount = (int) insert("poster.insertPoster", pvo);
        logger.debug("Upload Poster Method Called in PosterMapper");
        return insertedCount;
    }

    public List<PosterVo> selectAllPosterByEmail(String email) {
        @SuppressWarnings("unchecked")
		List<PosterVo> list = (List<PosterVo>) selectList("poster.selectAllPosterByEmail", email);
        return list;
    }
    
    public PosterVo selectPosterByImageName(String image) {
    	logger.debug("Get Image Information From DB");
    	PosterVo pvo = (PosterVo) selectOne("poster.selectPosterByImageName");
    	return pvo;
    }
 }
