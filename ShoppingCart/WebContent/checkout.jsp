<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="models.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout Page</title>
<link rel="stylesheet" href="styles/checkout.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div><center><h2>Your Basket</h2></center></div>
	
	<div class="showroom">
		
	</div>
	<div><center><h2>CheckOut</h2></center></div>
	<div class="checkout">
		<table class="table" id="checkouttable">
		<thead>
		<tr>
			<th>Product Name</th>
			<th>Product Brand</th>
			<th>Gross Price</th>
			<th>Discount</th>
			<th>Taxable Amount</th>
			<th>IGST</th>
			<th>Total</th>
		</tr>
		</thead>
		
		</table>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$.ajax({
				url:'addtocart',
				method:'GET',
				datatype:'JSON',
				success: function(data){
					if(data===null)
						{
							$('.showroom').append("<h1>OOPs!! Your Cart is Empty... Do Some Shopping</h1>");
						}
					else{
						$.each(data,function(index,prod){
							$('.showroom').append(
									'<div class="product-card">'+
									'<div><img src='+prod.pimage+' height="200px" width="300px"></div>'+
									'<div>'+prod.ptitle+'</div>'+
									'<div>Price : '+prod.pmrp+'</div>'+
									'<div>Brand : '+prod.pbrand+'</div>'+
									'<div>Available : '+prod.pstock+'<div>'+
									'</div>'		
							);
						});
					}
				},
				
				error: function(xhr,status,error){
					alert('Error occured while displaying cart',error);
				}
			
			});
			
			$.ajax({
				url:'checkout',
				method: 'POST',
				datatype:'json',
				success: function(data){
					$.each(data,function(index,order){
						$('#checkouttable').append(
							'<tr><td>'+order.product.ptitle+'</td>'+
							'<td>'+order.product.pbrand+'</td>'+
							'<td>'+order.product.pmrp+'</td>'+
							'<td>'+order.discount+'</td>'+
							'<td>'+order.taxableamount+'</td>'+
							'<td>'+order.igst+'</td>'+
							'<td>'+order.total+'</td>'+
							'</tr>'
						);
					});
					
				},
				error: function(xhr,status,error){
					alert("Checkout failed...")
				}
			});
		});
		
		
	</script>
</body>
</html>