export function TeamMember(name, role, salary) {
    this.name = name;
    this.role = role;
    this.salary = salary;
  }
  
  export function calculateTeamBudget(team) {
    let totalBudget = 0;
    for (let i = 0; i < team.length; i++) {
      totalBudget += team[i].salary;
    }
    return totalBudget;
  }
  