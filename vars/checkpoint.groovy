
def previousBuildStageSuccess(String stageName) {
    def dir = System.getenv('JENKINS_HOME') + "/workspace/" + "$JOB_BASE_NAME@checkpoint"

    File folder = new File(dir)
    File[] listOfFiles = folder.listFiles()

    for (File file : listOfFiles) {
        if (file.getName().equals(stageName))
            return false // do stage
    }
    return true // skip stage
}

def call(String stageName) {
   return previousBuildStageSuccess(stageName)
}
