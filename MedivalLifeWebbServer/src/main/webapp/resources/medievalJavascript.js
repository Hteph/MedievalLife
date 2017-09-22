/**
 * 
 */


var collapseButton = document.getElementById('collapseArticle').addEventListener('click', collapseArticle);




$('.icon').click(function(){$(this).parent().parent().next().toggle();});

$('.largeIcon').click(function(){$(this).parent().next().toggle();});
$('#readability').click('click', changeFont);


function changeFont(){
		
	var bodyText = document.querySelector('body');
	
	bodyText.style.fontFamily = 'serif';
	
	$(this).hide();
		
}


function collapseArticle(){
	
	var collapseButton = document.getElementById('collapseArticle');

	
	$("article").each(function(){$(this).hide('slow');})
	
	collapseButton.innerHTML="Expand All";
	collapseButton.removeEventListener('click', collapseArticle);
	collapseButton.addEventListener('click', expandArticle);
	
}

function expandArticle(){
	
	var collapseButton = document.getElementById('collapseArticle');
//	var chronicleText = document.querySelectorAll("article");
	
	$("article").each(function(){$(this).show('fast');})
	
	collapseButton.innerHTML="Collapse All";
	collapseButton.removeEventListener('click',expandArticle);
	collapseButton.addEventListener('click', collapseArticle);
}
