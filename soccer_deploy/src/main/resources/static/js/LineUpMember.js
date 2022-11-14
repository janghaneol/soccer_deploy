function LineUpMember(backNum, name, goal, assist, point, quarter, playerId) {
  this.backNum = backNum;
  this.name = name;
  this.goal = goal;
  this.assist = assist;
  this.point = point;
  this.quarter = quarter;
  this.playerId = playerId
}
LineUpMember.prototype.toString = function () {
  return `${this.backNum},${this.name},${this.goal},${this.assist},${this.point},${this.quarter},${this.playerId}`
}

export { LineUpMember }