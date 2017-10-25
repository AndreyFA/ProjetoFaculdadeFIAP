$(document).ready(function() {
    $('#btnEntrar').click(function() {
        if(validarFormulario(this, event)) {
            window.location.href = $(this).attr('href');
        }
    });

     $('.btnFinaliza').click(function() {
        validarFormulario(this, event)
    });

    $('.tipoCalendario').datepicker({
        dateFormat: "dd-mm-yy"
    });

    $('.tipoHorario').mask('00:00');
});

function limparValidacao(elemento) {
    $(elemento).closest('.form-group').removeClass('has-error').removeClass('has-warning');
    $(elemento).siblings('.help-block').remove();
}

function validarFormulario(elemento, event) {
    event.preventDefault();

    var formularioValido = true;
    var camposObrigatorios = $(elemento).closest('.container-fluid').find('input[required].form-control');

    camposObrigatorios.each(function() {
        $(this).click(function() {
            limparValidacao(this);
        });

        if(!validarPreenchimento(this)) {
            formularioValido = false;
        }
    });

    return formularioValido;
}

function validarPreenchimento(elemento) {
    var conteudo = $(elemento).val();

    if(conteudo == '') {
        dadoObrigatorioNaoPreenchido(elemento);
        return false;
    }

    if($(elemento).is('.tipoNumerico')) {
        if(!numeroValido(conteudo)) {
            dadoNoFormatoInvalido(elemento, "Informe apenas números.");
            return false;
        }
    }

    if($(elemento).is('.tipoEmail')) {
        if(!emailValido(conteudo)) {
            dadoNoFormatoInvalido(elemento, "E-mail inválido.");
            return false;
        }
    }

    if($(elemento).is('.tipoHorario')) {
        if(!horarioValido(conteudo)) {
            dadoNoFormatoInvalido(elemento, "Horário inválido.");
            return false;
        }
    }

    return true;
}

function numeroValido(valor) {
    return /^[0-9]{1,10}$/.test(valor);
}

function emailValido(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function horarioValido(horario) {
    return /^([2][0-3]|[01]?[0-9])([.:][0-5][0-9])?$/.test(horario);
}

function dadoObrigatorioNaoPreenchido(elemento) {
    $(elemento).closest('.form-group').find('.help-block').remove();
    $(elemento).after(criarTextoDeValidacao('Campo obrigatório.'));
    $(elemento).closest('.form-group').addClass('has-error');
}

function dadoNoFormatoInvalido(elemento, mensagem) {
    $(elemento).closest('.form-group').find('.help-block').remove();
    $(elemento).after(criarTextoDeValidacao(mensagem));
    $(elemento).closest('.form-group').addClass('has-warning');
}

function obterFormulario() {
    var usuario = {
        login: $('#login'),
        senha: $('#senha'),
        manterConectado: $('#manterConectado').is(':checked')
    };

    return usuario;
}

function criarTextoDeValidacao(texto) {
    return $('<span><span>').text(texto).addClass('help-block');
}