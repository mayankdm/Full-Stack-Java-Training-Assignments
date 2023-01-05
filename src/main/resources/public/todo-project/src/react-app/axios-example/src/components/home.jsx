import React from 'react'
import CocktailList from './cocktail'
import SearchForm from './search-form'
export default function Home() {
    return (
        <main>
            <SearchForm />
            <CocktailList />
        </main>
    )
}