CREATE TABLE IF NOT EXISTS t_profesor (
  id INT(16) UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre	varchar(120),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS t_curso (
  id INT(16) UNSIGNED NOT NULL AUTO_INCREMENT,
  titulo	varchar(120),
  nivel	    varchar(120),
  horas	    INT(11),
  activo    BOOLEAN,
  profesor	INT(11),
  documento varchar(120),
 PRIMARY KEY (id)
);


