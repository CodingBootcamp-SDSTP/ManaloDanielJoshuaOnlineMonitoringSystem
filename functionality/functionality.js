window.onload = function() {
	document.getElementById('btn').onclick = function() {
		var container = document.getElementById('goeshere');
		var un = document.getElementById('un').innerHTML;
		var pw = document.getElementById('pw').innerHTML;
		var rq = new XMLHttpRequest();
		rq.onreadystatechange = function() {
			if(rq.readyState == 4) {
				container.innerHTML = "";
				container.innerHTML = rq.responseText;
			}
		}
		rq.open("GET", "/login?username="+un+"&password="+pw, true);
		rq.send();
	};
	document.getElementById('btnlogin').onclick = function() {
		var container = document.getElementById('goeshere');
		var lform = document.getElementById('loginform');
		container.innerHTML = "";
		container.innerHTML = lform.innerHTML;
		alert('log');
	};
	document.getElementById('btnhome').onclick = function() {
		var container = document.getElementById('goeshere');
		var home = document.getElementById('home');
		container.innerHTML = "";
		container.innerHTML = home.innerHTML;
		alert('home');
	};
}