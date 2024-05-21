function updateItem(itemId, action) {
	fetch(`/${action}_item/${itemId}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		}
	})
		.then(response => response.json())
		.then(data => {
			document.querySelector(`#item-${itemId} .storage`).innerText = data.storage;
		})
		.catch(error => console.error('Error:', error));
}

function updateFavorite(itemId) {
    fetch(`/favorite_item/${itemId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            // Optionally update the UI for favorite status
        })
        .catch(error => console.error('Error:', error));
}