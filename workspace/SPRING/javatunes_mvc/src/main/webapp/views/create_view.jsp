<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>JavaTunes</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/style.css"
	type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Copse:regular"
	rel="stylesheet" type="text/css">
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<div id="wrapper">
		<!-- #wrapper -->

		<nav>
			<!-- top nav -->
			<div class="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}">Home</a></li>
					<li><a href="#">Cart</a></li>
					<li><a href="#">Checkout</a></li>
				</ul>
			</div>
		</nav>
		<!-- end of top nav -->

		<header>
			<!-- header -->

			<h1>JavaTunes</h1>
		</header>
		<!-- end of header -->

		<section id="main">
			<!-- #main content area -->




			<!-- One columns, 1 article column -->
			<section id="singlecol">
				<article>

					<p>
						<img
							src="${pageContext.servletContext.contextPath}/resources/images/music.png"
							width="64" height="64" alt="tag" class="alignleft">
					</p>

					<h2>Search</h2>

					<form:form modelAttribute="item">
						<div>
							Title:
							<form:input size='20' path='title' />
						</div>

						<div>
							Artist:
							<form:input size='20' path='artist' />
						</div>

						<div>
							Price:
							<form:input size='20' path='price' />
						</div>
						<div>
							Category:
							<form:select path="musicCategory" items="${categories}" />
						</div>
						
						<input type='submit' name='Submit' value='Go' />
					</form:form>
				</article>
			</section>

		</section>
		<!-- end of #main content -->

		<footer>
			<section id="footer-area">
				<aside class="footer-segment first">
					<h3>The Java-Powered Online Music Store</h3>
				</aside>

				<section id="footer-outer-block"></section>
				<!-- end of footer-outer-block -->

			</section>
			<!-- end of footer-area -->
		</footer>

	</div>
	<!-- #wrapper -->
</body>
</html>
