//wait until the page loads
window.onload = async function () {
    //fetch the data
    const uri = "http://localhost:3000/api/v1/movies/all";
    const config = {
        method: 'get'
    }

    //using these three lines of code instead of the .then() shown below
    const response = await fetch(uri, config);
    const data = await response.json();
    showMovies(data);

    /*fetch(uri, config)
        .then(function (response) {
            console.log(response);

            //returns another promise
            return response.json();
        })
        .then(function (data) {
            //update our UI
            console.log(data);
            showMovies(data);
        });*/

    //select form button and handle form submission
    const button = document.querySelector("button");
    button.onclick = addMovie;

}

async function addMovie(event) {
    event.preventDefault(); //stop form from submitting

    const newMovie = {
        title: document.querySelector("#title").value,
        genre: document.querySelector("#genre").value
    }

    const uri = "http://localhost:3000/api/v1/movies";
    const config = {
        method: 'post',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newMovie)
    }

    const response = await fetch(uri, config);
    const movie = await response.json();
    console.log(response);
    console.log(movie);

    const section = document.querySelector("#movies");
    addMovieSection(section, movie);
}

function showMovies(movies)
{
    const section = document.querySelector("#movies");
    //console.log(section);

    //loop over each of the movies and add a nested element
    for (let i = 0; i < movies.length; i++)
    {
        const movie = movies[i];

        addMovieSection(section, movie);

    }
}

function addMovieSection(section, movie)
{
    section.innerHTML +=`<div class="movie">
            <h2>${movie.title}</h2>
            <p>ID #${movie.id}</p>
            <p>Genre: ${movie.genre}</p>
        </div>`;
}
