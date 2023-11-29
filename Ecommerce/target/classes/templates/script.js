function addToCart(productId) {
    const product = document.getElementById(productId);
    const productName = product.querySelector('h2').innerText;

    const cartItems = document.getElementById('cart-items');
    const listItem = document.createElement('li');
    listItem.innerText = productName;
    cartItems.appendChild(listItem);
}

function checkout() {
    const cartItems = document.getElementById('cart-items');
    cartItems.innerHTML = '';
    alert('Thank you for your purchase!');
}