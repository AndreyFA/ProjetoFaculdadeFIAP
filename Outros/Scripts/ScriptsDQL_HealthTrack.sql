-- Consultar os dados de um determinado usuário (filtrar a partir do seu código)
SELECT 
        cd_usuario,
        nm_usuario,
        dt_nascimento,
        vl_altura,
        ds_genero,
        ds_email,
        ds_senha
FROM T_HLT_USUARIO
WHERE cd_usuario = [código de usuário];

/*
    Consultar todos os dados de todos os registros de peso de um determinado usuário, 
    ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código);
*/
        
SELECT 
        cd_peso,
        vl_peso,
        dt_peso,
        cd_usuario
FROM T_HLT_PESO
WHERE cd_usuario = [código de usuário]
ORDER BY dt_peso DESC;

/*
    Consultar todos os dados de um único registro de peso de um determinado usuário 
    (filtrar a partir do código do usuário e do código de peso);
*/

SELECT 
        cd_peso,
        vl_peso,
        dt_peso,
        cd_usuario
FROM T_HLT_PESO
WHERE ROWNUM = 1
  AND cd_usuario = [código de usuário]
  AND cd_peso = [código de peso]
ORDER BY dt_peso ASC;

/*
    Consultar todos os dados de todos os registros de pressão arterial de um determinado usuário, 
    ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código);
*/

SELECT 
        cd_pressao_arterial,
        vl_pressao_sistolica,
        vl_pressao_diastolica,
        dt_medicao,
        ds_situacao,
        cd_usuario
FROM T_HLT_PRESSAO_ARTERIAL
WHERE cd_usuario = [código de usuário]
ORDER BY dt_medicao DESC;

/*
    Consultar todos os dados de um único registro de pressão arterial de um determinado usuário 
    (filtrar a partir do código do usuário e do código de pressão);
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
  AND cd_usuario = [código de usuário]
  AND cd_pressao_arterial = [código de pressão arterial]
ORDER BY dt_medicao DESC;

/*
    Consultar todos os dados de todos os registros de atividade física de um determinado usuário, 
    ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código);
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
WHERE cd_usuario = [código de usuário]
ORDER BY dt_atividade, hr_atividade DESC;

/*
    Consultar todos os dados de um único registro de atividade física de um determinado usuário 
    (filtrar a partir do código do usuário e do código de atividade);
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
  AND cd_usuario = [código de usuário]
  AND cd_atividade_fisica = [código de atividade físca]
ORDER BY dt_atividade, hr_atividade DESC;

/*
    Consultar todos os dados de todos os registros de alimentos ingeridos de um determinado usuário, 
    ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código);
*/

SELECT 
        cd_alimento_consumido,
        nr_calorias,
        hr_refeicao,
        ds_refeicao,
        cd_tipo_refeicao,
        cd_usuario
FROM T_HLT_ALIMENTO_CONSUMIDO
WHERE cd_usuario = [código de usuário]
ORDER BY hr_refeicao DESC;

/*
    Consultar todos os dados de um único registro de alimento ingerido de um determinado usuário 
    (filtrar a partir do código do usuário e do código de alimento);
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
  AND cd_usuario = [código de usuário]
  AND cd_alimento_consumido = [código de alimento consumido]
ORDER BY hr_refeicao DESC;

/*
    Consultar os dados básicos de um determinado usuário, o último peso registrado e a última pressão arterial registrada 
    (filtrar a partir do código de usuário – consulta necessária para o dashboard, dica: veja consulta com junções).
*/

SELECT
        US.*,
        PS.vl_peso                                                  AS 'Último peso registrado',
        (PA.vl_pressao_sistolica || '/' || vl_pressao_diastolica)   AS 'Última pressão registrada'
FROM T_HLT_USUARIO                      US
  INNER JOIN T_HLT_PESO                 PS ON (PS.cd_usuario = US.cd_usuario)
  INNER JOIN T_HLT_PRESSAO_ARTERIAL     PA ON (PA.cd_usuario = US.cd_usuario)
WHERE ROWNUM = 1
  AND US.cd_usuario = [código de usuário]
ORDER BY PS.dt_peso, PA.dt_medicao DESC;
