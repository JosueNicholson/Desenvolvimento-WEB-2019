var numero1 = document.querySelector("#numero1").value;
var numero2 = document.querySelector("#numero2").value;

document.querySelector("#botaoAdicao").addEventListener("click", function(){
    var resultado = parseInt(numero1) + parseInt(numero2);
    document.querySelector("#resultado").value = resultado;
});

document.querySelector("#botaoSubtracao").addEventListener("click", function(){
    var resultado = parseInt(numero1) - parseInt(numero2);
    document.querySelector("#resultado").value = resultado;
});

document.querySelector("#botaoDivisao").addEventListener("click", function(){
    var resultado = parseInt(numero1) / parseInt(numero2);
    document.querySelector("#resultado").value = resultado;
})

document.querySelector("#botaoMultiplicacao").addEventListener("click", function(){
    var resultado = parseInt(numero1) * parseInt(numero2);
    document.querySelector("#resultado").value = resultado;
})