package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ehm.ReadingCMS.Model.PostMetadata;

public class postMetadataMapper implements RowMapper<PostMetadata> {

	@Override
	public PostMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostMetadata postMetadata = new PostMetadata();
		postMetadata.setClave(rs.getString("Calve"));
		postMetadata.setIdPostMetadata(rs.getInt("IdPostMetadata"));
		postMetadata.setIsPost(rs.getInt("IdPost"));
		postMetadata.setTipo(rs.getNString("Tipo"));
		postMetadata.setValor(rs.getString("Metadata"));
		return null;
	}

}
