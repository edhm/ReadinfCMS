package com.ehm.ReadingCMS.Model;

import java.util.Date;

public class Comentario {
private long IdCOmentario;
private String Comentario;
private long Idpost;
private long IdUsuario;
private Date Fecha;
private String Respuesta;

public long getIdCOmentario() {
	return IdCOmentario;
}

public void setIdCOmentario(long idCOmentario) {
	IdCOmentario = idCOmentario;
}

public String getComentario() {
	return Comentario;
}

public void setComentario(String comentario) {
	Comentario = comentario;
}

public long getIdpost() {
	return Idpost;
}

public void setIdpost(long idpost) {
	Idpost = idpost;
}

public long getIdUsuario() {
	return IdUsuario;
}

public void setIdUsuario(long idUsuario) {
	IdUsuario = idUsuario;
}

public Date getFecha() {
	return Fecha;
}

public void setFecha(Date fecha) {
	Fecha = fecha;
}

public String getRespuesta() {
	return Respuesta;
}

public void setRespuesta(String respuesta) {
	Respuesta = respuesta;
}
}
