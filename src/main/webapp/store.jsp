<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="models.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/storestyle.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
	<div id="searchoptions">
		<select class="form-select" name="category" id="category">
			<option selected>Choose one Category</option>
		</select>
		<select class="form-select">
			<option selected>Choose one Price Range</option>
			<option value="mintomax">Minimum to Maximum</option>
			<option value="maxtomin">Maximum to Minimum</option>
		</select>
		<div class="cart"><i class="bi bi-cart3"></i></div>
	</div>
	<div id="products" class="showroom"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
		$.ajax({
			url:'categories',
			type:'POST',
			datatype:'JSON',
			success:function(data){
				$.each(data,function(index,obj){
					$('#category').append('<option value="'+obj.categories+'">'+obj.categories+'</option>');
				});
			},
			error:function(xhr,status,error){
				console.error('Error fetching dropdown values: ',error);
			}
		});
		$.ajax({
			url:'products',
			type:'POST',
			datatype:'JSON',
			success:function(data){
				$.each(data,function(index,obj){
					$('#products').append('<div class="pcard"><div><img src="'+obj.pimage+'" height="200px" width="300px"></div><div>'+obj.ptitle+'</div><div>Product Brand : '+obj.pbrand+'</div><div>Price : '+obj.pmrp+'</div><div>Availability : '+obj.pstock+'</div><div><button class="btn btn-primary" id="add-to-cart" data-productid='+obj.pid+'>Add to Cart <i class="bi bi-cart"></i></button></div></div>');
					
				});
			},
			error:function(xhr,status,error){
				console.error('Error fetching Products: ',error);
			}
		})
	})
	
	$('#category').change(function(){
		
		var sharedcategory=$(this).val();
		$.ajax({
			url:'products',
			type:'GET',
			data:{'category':sharedcategory},
			success:function(data){
				$('#products').empty();
				$.each(data,function(index,obj){
					$('#products').append('<div class="pcard"><div><img src="'+obj.pimage+'" height="200px" width="300px"></div><div>'+obj.ptitle+'</div><div>Product Brand : '+obj.pbrand+'</div><div>Price : '+obj.pmrp+'</div><div>Availability : '+obj.pstock+'</div><div><button class="btn btn-primary">Add to Cart <i class="bi bi-cart"></i></button></div></div>');
					
				});
			},
			error:function(xhr,status,error){
				console.error('Error fetching Products: ',error);
			}
			
		})
	})
	
	$('#add-to-cart').click(function(){
			var productId = $(this).data('productid');
			var pincode = alert('Enter Your PinCode Here...');
			if(pincode!=null && pincode!="")
				{
				$.ajax({
					url:'checkserviceavailability',
					method:'POST',
					data: {pincode:pincode},
					success: function(response){
						if(response==='available')
							{
							$.ajax({
								url: 'addtocart',
								method:'POST',
								data:{productId:productId},
								success: function(data){
									alert('product added to cart successfully!!');
								},
								error: function(xhr,status,error){
									alert('error occured while adding product to the cart...',error);
								}
							});
							}else{
								alert('Service is not available in your region.');
							}
				},
				error: function(xhr,status,error){
					alert('error occured while validating PIN Code...',error);
				}
				});
			
			}
		})
	</script>
</body>
</html>