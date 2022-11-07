function LineUpMember(backNum, name, goal, assist, point, quarter, player_id) {
  this.backNum = backNum;
  this.name = name;
  this.goal = goal;
  this.assist = assist;
  this.point = point;
  this.quarter = quarter;
  this.player_id = player_id
}
LineUpMember.prototype.toString = function () {
  return `${this.backNum},${this.name},${this.goal},${this.assist},${this.point},${this.quarter},${this.player_id}`
}

export { LineUpMember }