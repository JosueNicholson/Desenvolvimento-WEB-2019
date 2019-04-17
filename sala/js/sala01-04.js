var buttonCriar = document.querySelector("#botaoCriar");
console.log(buttonCriar);
var i = 1;

buttonCriar.addEventListener("click", function() {
    var item = document.createElement("li");
    var textItem = document.createTextNode("Item "+i);
    item.appendChild(textItem);
    
    document.querySelector("#lista").appendChild(item);
    i++;
});


var buttonRemover = document.querySelector("#botaoRemover");

buttonRemover.addEventListener("click", function(){
    var lista = document.querySelector("#lista");
    lista.removeChild(lista.childNodes[0]);
});






