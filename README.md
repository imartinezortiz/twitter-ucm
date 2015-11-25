# Eclipse STS workspace setup

Configure Java assistant options (Window > Preferences > Java > Editor > Content Assits > Favorites), adding the following entries:
  - org.hamcrest.Matchers
  - org.hamcrest.CoreMatchers
  - org.junit
  - org.mockito.Mockito
  - org.hamcrest.MatcherAssert
  - org.mockito.Matchers

This facilitates the JUnit + Mockito + Hamcrest test cases.

Import the code styling rules ( Window > Preferences > Java > Code Style > Formatter > Import... ). Use the [TFG exported profile file](src/etc/eclipse/code-formatter-preferences.xml), to import the profile to be used in the project.

# Project setup

1. Import the project: File > Import... > Maven > Existing Maven Projects
2. Configure the project formatter (Project > Properties > Java Code Sytle > Formatter ):
  1. Enable project specific settings
  2. Select TFG in the "Active profile" dropdown menu.