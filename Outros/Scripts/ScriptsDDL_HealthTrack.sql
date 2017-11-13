CREATE TABLE t_hlt_alimento_consumido (
    cd_alimento_consumido   INTEGER NOT NULL,
    nr_calorias             INTEGER NOT NULL,
    hr_refeicao             DATE NOT NULL,
    ds_refeicao             VARCHAR2(80),
    cd_tipo_refeicao        INTEGER NOT NULL,
    cd_usuario              INTEGER NOT NULL
);

ALTER TABLE t_hlt_alimento_consumido ADD CONSTRAINT t_hlt_alimento_consumido_pk PRIMARY KEY ( cd_alimento_consumido );

CREATE TABLE t_hlt_atividade_fisica (
    cd_atividade_fisica        INTEGER NOT NULL,
    nr_calorias                INTEGER NOT NULL,
    dt_atividade               DATE NOT NULL,
    hr_atividade               TIMESTAMP NOT NULL,
    ds_atividade               VARCHAR2(80),
    cd_tipo_atividade_fisica   INTEGER NOT NULL,
    cd_usuario                 INTEGER NOT NULL
);

ALTER TABLE t_hlt_atividade_fisica ADD CONSTRAINT t_hlt_atividade_fisica_pk PRIMARY KEY ( cd_atividade_fisica );

CREATE TABLE t_hlt_peso (
    cd_peso      INTEGER NOT NULL,
    vl_peso      NUMBER(4,2) NOT NULL,
    dt_peso      DATE NOT NULL,
    cd_usuario   INTEGER NOT NULL
);

ALTER TABLE t_hlt_peso ADD CONSTRAINT t_hlt_peso_pk PRIMARY KEY ( cd_peso );

CREATE TABLE t_hlt_pressao_arterial (
    cd_pressao_arterial     INTEGER NOT NULL,
    vl_pressao_sistolica    INTEGER NOT NULL,
    vl_pressao_diastolica   INTEGER NOT NULL,
    dt_medicao              DATE NOT NULL,
    ds_situacao             VARCHAR2(20) NOT NULL,
    cd_usuario              INTEGER NOT NULL
);

ALTER TABLE t_hlt_pressao_arterial ADD CONSTRAINT t_hlt_pressao_arterial_pk PRIMARY KEY ( cd_pressao_arterial );

CREATE TABLE t_hlt_tipo_atividade_fisica (
    cd_tipo_atividade_fisica   INTEGER NOT NULL,
    nm_atividade_fisica        VARCHAR2(80) NOT NULL
);

ALTER TABLE t_hlt_tipo_atividade_fisica ADD CONSTRAINT t_hlt_tipo_atividade_fisica_pk PRIMARY KEY ( cd_tipo_atividade_fisica );

CREATE TABLE t_hlt_tipo_refeicao (
    cd_tipo_refeicao   INTEGER NOT NULL,
    nm_refeicao        VARCHAR2(80) NOT NULL
);

ALTER TABLE t_hlt_tipo_refeicao ADD CONSTRAINT t_hlt_tipo_refeicao_pk PRIMARY KEY ( cd_tipo_refeicao );

CREATE TABLE t_hlt_usuario (
    cd_usuario      INTEGER NOT NULL,
    nm_usuario      VARCHAR2(80) NOT NULL,
    dt_nascimento   DATE NOT NULL,
    vl_altura       NUMBER(3) NOT NULL,
    ds_genero       VARCHAR2(10) NOT NULL,
    ds_email        VARCHAR2(80) NOT NULL,
    ds_senha        VARCHAR2(15) NOT NULL
);

ALTER TABLE t_hlt_usuario ADD CONSTRAINT t_hlt_usuario_pk PRIMARY KEY ( cd_usuario );

ALTER TABLE t_hlt_alimento_consumido ADD CONSTRAINT alm_consumido_tipo_refeicao_fk FOREIGN KEY ( cd_tipo_refeicao )
    REFERENCES t_hlt_tipo_refeicao ( cd_tipo_refeicao );

ALTER TABLE t_hlt_alimento_consumido ADD CONSTRAINT alm_consumido_usuario_fk FOREIGN KEY ( cd_usuario )
    REFERENCES t_hlt_usuario ( cd_usuario );

ALTER TABLE t_hlt_atividade_fisica ADD CONSTRAINT ativ_fisica_tp_ativ_fisica_fk FOREIGN KEY ( cd_tipo_atividade_fisica )
    REFERENCES t_hlt_tipo_atividade_fisica ( cd_tipo_atividade_fisica );

ALTER TABLE t_hlt_atividade_fisica ADD CONSTRAINT ativ_fisica_usuario_fk FOREIGN KEY ( cd_usuario )
    REFERENCES t_hlt_usuario ( cd_usuario );

ALTER TABLE t_hlt_peso ADD CONSTRAINT peso_usuario_fk FOREIGN KEY ( cd_usuario )
    REFERENCES t_hlt_usuario ( cd_usuario );

ALTER TABLE t_hlt_pressao_arterial ADD CONSTRAINT pressao_arterial_usuario_fk FOREIGN KEY ( cd_usuario )
    REFERENCES t_hlt_usuario ( cd_usuario );


CREATE SEQUENCE SQ_ALIMENTO_CONSUMIDO
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_ATIVIDADE_FISICA
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_PESO
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_PRESSAO_ARTERIAL
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_TIPO_ATIVIDADE_FISICA
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_TIPO_REFEICAO
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOCYCLE;

CREATE SEQUENCE SQ_USUARIO
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOCYCLE;


select * from t_hlt_peso