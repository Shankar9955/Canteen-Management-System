
function AddCart(pId, pTitle, pPrice) {
    let cart = localStorage.getItem("cart");
    if (cart == null) {

        let products = [];
        let product = {id: pId, title: pTitle, quantity: 1, price: pPrice};
        products.push(product);
        localStorage.setItem("cart", JSON.stringify(products));
        console.log("Product Add first time");

    }

//     Cart is already present

    else {
        let pcart = JSON.parse(cart);
        let oldProduct = pcart.find((item) => item.id == pId)
        if (oldProduct) {
            oldProduct.quantity = oldProduct.quantity + 1
            pcart.map((item) => {
                if (item.id == oldProduct.id) {
                    item.quantity = oldProduct.quantity;
                }
            })
            localStorage.setItem("cart", JSON.stringify(pcart));
            console.log("Product Quantity Increase");
        } else {

//             We Have The Poduct
            let product = {id: pId, title: pTitle, quantity: 1, price: pPrice};
            pcart.push(product);
            localStorage.setItem("cart", JSON.stringify(pcart));


        }
    }
}

