document.addEventListener("DOMContentLoaded", function() {
	var buttons = document.getElementsByClassName("plus-button");

	for (var i = 0; i < buttons.length; i++) {
		buttons[i].addEventListener("click", function(event) {
			var id = this.getAttribute("data-id");

			fetch('/plus_item/' + id, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(response => {
				if (response.ok) {
					console.log("Item updated successfully");
					// 必要に応じてページをリロードするか、データを更新する
					location.reload(); // ページをリロード
				} else {
					console.error("Error updating item");
				}
			}).catch(error => {
				console.error("Network error:", error);
			});

			event.preventDefault(); // フォームのデフォルトの送信を防ぐ
		});
	}

	var minusButtons = document.getElementsByClassName("minus-button");
	for (var i = 0; i < minusButtons.length; i++) {
		minusButtons[i].addEventListener("click", function(event) {
			var id = this.getAttribute("data-id");

			fetch('/minus_item/' + id, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(response => {
				if (response.ok) {
					console.log("Item decremented successfully");
					location.reload(); // ページをリロード
				} else {
					console.error("Error decrementing item");
				}
			}).catch(error => {
				console.error("Network error:", error);
			});

			event.preventDefault(); // フォームのデフォルトの送信を防ぐ
		});
	}
	var favoriteButtons = document.getElementsByClassName("favorite-button");
	for (var i = 0; i < favoriteButtons.length; i++) {
		favoriteButtons[i].addEventListener("click", function(event) {
			var id = this.getAttribute("data-id");

			fetch('/favorite_item/' + id, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(response => {
				if (response.ok) {
					console.log("Item favorite status toggled successfully");
					location.reload(); // ページをリロード
				} else {
					console.error("Error toggling favorite status");
				}
			}).catch(error => {
				console.error("Network error:", error);
			});

			event.preventDefault(); // デフォルトのフォーム送信を防ぐ
		});
	}
});