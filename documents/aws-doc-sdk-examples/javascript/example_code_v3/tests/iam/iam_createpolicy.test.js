const mockCreatePolicy = jest.fn();
jest.mock("@aws-sdk/client-iam/commands/CreatePolicyCommand", () => ({
  IAM: function IAM() {
    this.CreatePolicyCommand = mockCreatePolicy;
  },
}));
const { params, run } = require("../../iam/iam_createpolicy.js");

//test function
test("has to mock iam#createpolicy", async (done) => {
  await run();
  expect(mockCreatePolicy).toHaveBeenCalled;
  done();
});
