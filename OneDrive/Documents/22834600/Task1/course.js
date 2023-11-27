// Define a function to fetch data from JSON file
function fetchData() {
// Fetch data from the "course.json" file using the Fetch API.
fetch("course.json")
// Get the response as JSON data.
.then(response => response.json())
// Call the displayData function to render the data in table format.
.then(course => displayData(course.courses))
// If there's an error, log it to the console.
.catch(error => console.error(error));
}

// Define a function to display data in table format
function displayData(courses) {
// Create a table element.
const table = document.createElement("table");
// Set the table headers row.
table.innerHTML = `<tr> <th>Course Icon</th> <th>Course Title</th> <th>Level</th> <th>Duration</th> <th>Mode of Study</th> <th>Award</th> <th>Ucas Code</th> <th>Entry Requirements</th> <th>UK Pound</th> <th>Euro</th> <th>US Dollar</th> </tr>`;
// Loop through each course object and add a new row with its data to the table.
courses.forEach(course => {
const row = document.createElement("tr");
const iconCell = document.createElement("td");
const icon = document.createElement("img");
// Set the icon image source path.
icon.src = `icons/${course.courseIcon}`;
// Set the icon image alt attribute to the course title.
icon.alt = course.courseTitle;
iconCell.appendChild(icon);
row.appendChild(iconCell);
// Use template literals to add course data to the table row.
row.innerHTML += `<td>${course.courseTitle}</td> <td>${course.level}</td> <td>${course.courseDetails.duration}</td> <td>${course.courseDetails.modeOfStudy}</td> <td>${course.courseDetails.award}</td> <td>${course.courseDetails.ucasCode}</td> <td>${course.entryRequirements.join("<br>")}</td> <td>${course.feesAndFunding.ukPound}</td> <td>${course.feesAndFunding.euro}</td> <td>${course.feesAndFunding.usDollar}</td>`;
// Add the row to the table.
table.appendChild(row);
});
// Add the table to the body of the document.
document.body.appendChild(table);

// Set a timeout of 100 seconds to automatically update the data.
setTimeout(fetchData, 100000);
}

// Call fetchData function to start fetching data
fetchData(); // Call the fetchData function to start the data fetching and rendering process