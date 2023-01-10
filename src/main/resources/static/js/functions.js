function show_hide_password(target){
    var input = document.getElementById('password-input');
    if (input.getAttribute('type') == 'password') {
        target.classList.add('view');
        input.setAttribute('type', 'text');
    } else {
        target.classList.remove('view');
        input.setAttribute('type', 'password');
    }
    return false;
}


function change_info(){
    var form, button, address, number, email, label1, label2, label3, close, action;
    close = document.getElementById("close");
    close.style.display = "none";
    action = document.getElementById("action");
    action.setAttribute("value", "update");
    button = document.createElement("button");
    button.innerText = "Добавить";
    button.className = "btn btn-primary custom-button";
    form = document.getElementById("form");
    form.appendChild(button);
    address = document.getElementById("address-input");
    number = document.getElementById("number-input");
    email = document.getElementById("email-input");
    label1 = document.getElementById("label1");
    label2 = document.getElementById("label2");
    label3 = document.getElementById("label3");
    label1.remove();label2.remove();label3.remove();
    address.setAttribute("type", "text");
    number.setAttribute("type", "text");
    email.setAttribute("type", "text");
}