describe('Blogdoagi Search Test', () => {
  it('should search for "Produto" and display search results', () => {
    // Visit the website
    cy.visit('https://blogdoagi.com.br/')

    // Find the search icon and click on it
    cy.xpath('//button[contains(@class,"search-toggle")]')
      .click()

    // Find the search input field and type "Produto"
    cy.xpath('//input[@id="search-input"]')
      .type('Produto')

    // Find the search button and click on it
    cy.xpath('//button[@class="search-button"]')
      .click()

    // Verify that search results contain the text "Produto"
    cy.xpath('//h1[@class="search-title"]')
      .should('contain', 'Produto')
  })
})
