document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("sendButton").addEventListener("click", function() {
		var elements = document.getElementsByClassName("test");
		var data = [];

		for (var i = 0; i < elements.length; i++) {
			var element = elements[i];
			var currentValue = parseInt(element.textContent, 10);

			if (!isNaN(currentValue)) {
				var newValue = currentValue + 1;
				element.textContent = newValue;
				data.push(newValue);
			}
		}

		// Send data to Java server
		fetch('/updateValues', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ values: data })
		}).then(response => {
			if (response.ok) {
				console.log("Data sent successfully");
			} else {
				console.error("Error sending data");
			}
		});
	});
});