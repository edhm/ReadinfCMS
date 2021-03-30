package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ehm.ReadingCMS.Model.UsuarioMetadata;

public class UsuarioMetadataMapper implements RowMapper<UsuarioMetadata> {

	@Override
	public UsuarioMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioMetadata usuarioMetadata = new UsuarioMetadata();
		usuarioMetadata.setClave(rs.getString("Usuario"));
		usuarioMetadata.setIdUsuario(rs.getInt("IdUsuario"));
		usuarioMetadata.setTipo(rs.getString("Tipo"));
		usuarioMetadata.setValor(rs.getString("Valor"));
		return null;
	}

}
