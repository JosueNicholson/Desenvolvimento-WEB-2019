let nome = document.querySelector("#nomeProduto");
let preco = document.querySelector("#precoProduto");
let qtd = document.querySelector("#qtdProduto");
let tabela = document.querySelector("table");
let total = document.querySelector("#total");

let botaoCadastrar = document.querySelector("#botaoCadastrar");

let valorTotal = 0;

botaoCadastrar.addEventListener("click", function(){
    let tr = document.createElement("tr");

    let tdNome = document.createElement("td");
    let tdPreco = document.createElement("td");
    let tdQtd = document.createElement("td");
    let tdTotalItem = document.createElement("td");

    let textNome = document.createTextNode(nome.value);
    let textPreco = document.createTextNode(preco.value);
    let textqtd = document.createTextNode(qtd.value);
    let textTotalItem = parseInt(qtd.value) * parseFloat(preco.value);
    valorTotal += textTotalItem;;
    textTotalItem = document.createTextNode(textTotalItem.toFixed(2));

    tdNome.appendChild(textNome);
    tdPreco.appendChild(textPreco);
    tdQtd.appendChild(textqtd);
    tdTotalItem.appendChild(textTotalItem);

    tr.appendChild(tdNome);
    tr.appendChild(tdPreco);
    tr.appendChild(tdQtd);
    tr.appendChild(tdTotalItem);

    tabela.appendChild(tr);

    total.value = valorTotal.toFixed(2);

});