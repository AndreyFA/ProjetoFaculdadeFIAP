-- Consultar os dados de um determinado usu�rio (filtrar a partir do seu c�digo)
SELECT 
        cd_usuario,
        nm_usuario,
        dt_nascimento,
        vl_altura,
        ds_genero,
        ds_email,
        ds_senha
FROM T_HLT_USUARIO
WHERE cd_usuario = [c�digo de usu�rio];

/*
    Consultar todos os dados de todos os registros de peso de um determinado usu�rio, 
    ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu c�digo);
*/
        
SELECT 
        cd_peso,
        vl_peso,
        dt_peso,
        cd_usuario
FROM T_HLT_PESO
WHERE cd_usuario = [c�digo de usu�rio]
ORDER BY dt_peso DESC;

/*
    Consultar todos os dados de um �nico registro de peso de um determinado usu�rio 
    (filtrar a partir do c�digo do usu�rio e do c�digo de peso);
*/

SELECT 
        cd_peso,
        vl_peso,
        dt_peso,
        cd_usuario
FROM T_HLT_PESO
WHERE ROWNUM = 1
  AND cd_usuario = [c�digo de usu�rio]
  AND cd_peso = [c�digo de peso]
ORDER BY dt_peso ASC;

/*
    Consultar todos os dados de todos os registros de press�o arterial de um determinado usu�rio, 
    ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu c�digo);
*/

SELECT 
        cd_pressao_arterial,
        vl_pressao_sistolica,
        vl_pressao_diastolica,
        dt_medicao,
        ds_situacao,
        cd_usuario
FROM T_HLT_PRESSAO_ARTERIAL
WHERE cd_usuario = [c�digo de usu�rio]
ORDER BY dt_medicao DESC;

/*
    Consultar todos os dados de um �nico registro de press�o arterial de um determinado usu�rio 
    (filtrar a partir do c�digo do usu�rio e do c�digo de press�o);
*/

SELECT 
        cd_pressao_arterial,
        vl_pressao_sistolica,
        vl_pressao_diastolica,
        dt_medicao,
        ds_situacao,
        cd_usuario
FROM T_HLT_PRESSAO_ARTERIAL
WHERE ROWNUM = 1
  AND cd_usuario = [c�digo de usu�rio]
  AND cd_pressao_arterial = [c�digo de press�o arterial]
ORDER BY dt_medicao DESC;

/*
    Consultar todos os dados de todos os registros de atividade f�sica de um determinado usu�rio, 
    ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu c�digo);
*/

SELECT 
        cd_atividade_fisica,
        nr_calorias,
        dt_atividade,
        hr_atividade,
        ds_atividade,
        cd_tipo_atividade_fisica,
        cd_usuario
FROM T_HLT_ATIVIDADE_FISICA
WHERE cd_usuario = [c�digo de usu�rio]
ORDER BY dt_atividade, hr_atividade DESC;

/*
    Consultar todos os dados de um �nico registro de atividade f�sica de um determinado usu�rio 
    (filtrar a partir do c�digo do usu�rio e do c�digo de atividade);
*/

SELECT 
        cd_atividade_fisica,
        nr_calorias,
        dt_atividade,
        hr_atividade,
        ds_atividade,
        cd_tipo_atividade_fisica,
        cd_usuario
FROM T_HLT_ATIVIDADE_FISICA
WHERE ROWNUM = 1
  AND cd_usuario = [c�digo de usu�rio]
  AND cd_atividade_fisica = [c�digo de atividade f�sca]
ORDER BY dt_atividade, hr_atividade DESC;

/*
    Consultar todos os dados de todos os registros de alimentos ingeridos de um determinado usu�rio, 
    ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu c�digo);
*/

SELECT 
        cd_alimento_consumido,
        nr_calorias,
        hr_refeicao,
        ds_refeicao,
        cd_tipo_refeicao,
        cd_usuario
FROM T_HLT_ALIMENTO_CONSUMIDO
WHERE cd_usuario = [c�digo de usu�rio]
ORDER BY hr_refeicao DESC;

/*
    Consultar todos os dados de um �nico registro de alimento ingerido de um determinado usu�rio 
    (filtrar a partir do c�digo do usu�rio e do c�digo de alimento);
*/

SELECT 
        cd_alimento_consumido,
        nr_calorias,
        hr_refeicao,
        ds_refeicao,
        cd_tipo_refeicao,
        cd_usuario
FROM T_HLT_ALIMENTO_CONSUMIDO
WHERE ROWNUM = 1
  AND cd_usuario = [c�digo de usu�rio]
  AND cd_alimento_consumido = [c�digo de alimento consumido]
ORDER BY hr_refeicao DESC;

/*
    Consultar os dados b�sicos de um determinado usu�rio, o �ltimo peso registrado e a �ltima press�o arterial registrada 
    (filtrar a partir do c�digo de usu�rio � consulta necess�ria para o dashboard, dica: veja consulta com jun��es).
*/

SELECT
        US.*,
        PS.vl_peso                                                  AS '�ltimo peso registrado',
        (PA.vl_pressao_sistolica || '/' || vl_pressao_diastolica)   AS '�ltima press�o registrada'
FROM T_HLT_USUARIO                      US
  INNER JOIN T_HLT_PESO                 PS ON (PS.cd_usuario = US.cd_usuario)
  INNER JOIN T_HLT_PRESSAO_ARTERIAL     PA ON (PA.cd_usuario = US.cd_usuario)
WHERE ROWNUM = 1
  AND US.cd_usuario = [c�digo de usu�rio]
ORDER BY PS.dt_peso, PA.dt_medicao DESC;
