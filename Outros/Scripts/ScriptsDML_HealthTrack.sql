INSERT INTO T_HLT_USUARIO (
    cd_usuario, 
    nm_usuario, 
    dt_nascimento, 
    vl_altura, 
    ds_genero, 
    ds_email, 
    ds_senha
) VALUES (
    SQ_USUARIO.NEXTVAL,
    'Andrey Frazatti Alves',
    TO_DATE('12/11/91'),
    175,
    'M',
    'frazatti.andrey@email.com',
    'Senha@123'
);

UPDATE T_HLT_USUARIO 
   SET nm_usuario = 'Andrey F. Alves',
       dt_nascimento = '1991-11-12',
       vl_altura = 176, 
       ds_genero = 'M',
       ds_email = 'andrey.frazatti@email.com',
       ds_senha = 'Mudar@2017' 
 WHERE cd_usuario = 1;

INSERT INTO T_HLT_PESO (
    cd_peso,
    vl_peso,
    dt_peso,
    cd_usuario
) VALUES (
    SQ_PESO.NEXTVAL,
    64.45,
    TO_DATE('18-09-2017'),
    6
);

UPDATE T_HLT_PESO
   SET vl_peso = 65.05,
       dt_peso = '2017-09-19'
 WHERE cd_peso = 1;
 
 
INSERT INTO T_HLT_PRESSAO_ARTERIAL (
    cd_pressao_arterial,
    vl_pressao_sistolica,
    vl_pressao_diastolica,
    dt_medicao,
    ds_situacao,
    cd_usuario
) VALUES (
    SQ_PRESSAO_ARTERIAL.NEXTVAL,
    118,
    89,
    TO_DATE('19-09-2017'),
    'Normal',
    6
);

UPDATE T_HLT_PRESSAO_ARTERIAL
   SET vl_pressao_sistolica = 119,
       vl_pressao_diastolica = 88,
       dt_medicao = '2017-09-20',
       ds_situacao = 'Normal'
 WHERE cd_pressao_arterial = 1;
 
INSERT INTO T_HLT_TIPO_ATIVIDADE_FISICA (
    cd_tipo_atividade_fisica,
    nm_atividade_fisica
) VALUES (
    SQ_TIPO_ATIVIDADE_FISICA.NEXTVAL,
    'Musculação'
);
 
INSERT INTO T_HLT_ATIVIDADE_FISICA (
    cd_atividade_fisica,
    nr_calorias,
    dt_atividade,
    hr_atividade,
    ds_atividade,
    cd_tipo_atividade_fisica,
    cd_usuario
) VALUES (
    SQ_ATIVIDADE_FISICA.NEXTVAL,
    115,
    TO_DATE('18-09-2017'),
    TO_TIMESTAMP('18-09-2017 20:25:00'),
    'Abdominais',
    1,
    6
);

UPDATE T_HLT_ATIVIDADE_FISICA
   SET nr_calorias = 152,
       dt_atividade = '2017-09-20',
       hr_atividade = '21:58:00',
       ds_atividade = 'Flexão de braços',
       cd_tipo_atividade_fisica = 1
 WHERE cd_atividade_fisica = 1;
 

INSERT INTO T_HLT_TIPO_REFEICAO (
    cd_tipo_refeicao,
    nm_refeicao
) VALUES (
    SQ_TIPO_REFEICAO.NEXTVAL,
    'Café da manhã'
);
 
INSERT INTO T_HLT_ALIMENTO_CONSUMIDO (
    cd_alimento_consumido,
    nr_calorias,
    hr_refeicao,
    ds_refeicao,
    cd_tipo_refeicao,
    cd_usuario
) VALUES (
    SQ_ALIMENTO_CONSUMIDO.NEXTVAL,
    62,
    TO_DATE('19-09-2017'),
    'Barra de chocolate',
    1,
    6
);

UPDATE T_HLT_ALIMENTO_CONSUMIDO 
   SET nr_calorias = 67,
       hr_refeicao = '2017-09-20 10:15',
       ds_refeicao = 'Barra de cereais',
       cd_tipo_refeicao = '1'
 WHERE cd_alimento_consumido = 1;
    
