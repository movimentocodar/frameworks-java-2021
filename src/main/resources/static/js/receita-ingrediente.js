function getCelula(valor, campo) {
    let index = $('#tabelaIngredientes tr').length;
    let campoHidden = "<input type='hidden' value='" + valor + "' name='ingredientes[" + index + "]." + campo +"' />";
    return "<td>"+ valor + campoHidden + "</td>";
}

function adicionarIngrediente() {
    let nome = $("#ingredientesNome").val();
    let quantidade = $("#ingredientesQuantidade").val();
    let medida = $("#ingredientesMedida").val();
    let deleteButton = "<td><button type='button' class='btn btn-sm btn-danger' onclick='removerIngrediente(this)'><span aria-hidden='true'>&times;</span></button></td>"

    if(isValid(nome, quantidade, medida)) {
        let linha = "<tr>" +
            getCelula(nome, 'nome') +
            getCelula(quantidade, 'quantidade') +
            getCelula(medida, 'medida') +
            deleteButton
           "</tr>";

        $("#tabelaIngredientes").append(linha);
        $('#ingredienteForm').trigger("reset");
        $('#modalIngrediente').modal('hide');
    } else {
        alert("Preencha todos os campos!");
    }
}


function isValid(nome, quantidade, medida) {
    return nome != "" && nome != null && quantidade >= 1 && quantidade <= 1000 && medida != "Selecione um tipo de medida...";
}

function removerIngrediente(el) {
    $(el).closest("tr").remove();
}