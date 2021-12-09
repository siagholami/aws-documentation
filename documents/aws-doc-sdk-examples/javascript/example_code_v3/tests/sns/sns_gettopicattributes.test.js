const mockGetTopicAttributes = jest.fn();
jest.mock("@aws-sdk/client-sns/commands/GetTopicAttributesCommand", () => ({
  SNS: function SNS() {
    this.GetTopicAttributesCommand = mockGetTopicAttributes;
  },
}));
const { run } = require("../../sns/sns_gettopicattributes.js");

//test function
test("has to mock SNS#gettopicattributes", async (done) => {
  await run();
  expect(mockGetTopicAttributes).toHaveBeenCalled;
  done();
});
