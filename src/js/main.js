import { TeamMember, calculateTeamBudget } from './team';

// Sample team members
const team = [
  new TeamMember("John Doe", "Developer", 50000),
  new TeamMember("Jane Smith", "Designer", 60000),
  new TeamMember("Mike Johnson", "Tester", 45000)
];

// Display team members
const teamList = document.getElementById('team-list');
team.forEach(member => {
  const listItem = document.createElement('li');
  listItem.textContent = `${member.name} - ${member.role}`;
  teamList.appendChild(listItem);
});

// Calculate and display the total budget
const totalBudget = calculateTeamBudget(team);
const totalBudgetElement = document.getElementById('total-budget');
totalBudgetElement.textContent = `Total Budget: $${totalBudget}`;
