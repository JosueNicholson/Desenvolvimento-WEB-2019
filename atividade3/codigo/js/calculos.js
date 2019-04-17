let botaoAdicao = document.querySelector("#botaoAdicao");
let botaoSubtracao = document.querySelector("#botaoSubtracao");
let botaoMultiplicacao = document.querySelector("#botaoMultiplicacao");
let botaoDivisao= document.querySelector("#botaoDivisao");

let numero1 = document.querySelector("#numero1");
let numero2 = document.querySelector("#numero2");
let campoResult = document.querySelector("#result");

botaoAdicao.addEventListener("click", function(){
    let result = parseInt(numero1.value) + parseInt(numero2.value);
    campoResult.value = result;
});
botaoSubtracao.addEventListener("click", function(){
    let result = parseInt(numero1.value) - parseInt(numero2.value);
    campoResult.value = result;
});
botaoMultiplicacao.addEventListener("click", function(){
    let result = parseInt(numero1.value) * parseInt(numero2.value);
    campoResult.value = result;
});
botaoDivisao.addEventListener("click", function(){
    let result = parseInt(numero1.value) / parseInt(numero2.value);
    campoResult.value = result;
});