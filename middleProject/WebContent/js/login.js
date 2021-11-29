const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});

modal = function(url, memVO){
	window.open(url)
	
}

openModal = function (url) {
	window.open(url, "아이디 찾기", "width=400, height=500");
}
